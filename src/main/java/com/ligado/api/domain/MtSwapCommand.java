package com.ligado.api.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Null;

import org.aspectj.util.LangUtil.StringChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.ligado.api.exception.BadCommandDataException;
import com.ligado.api.service.api.dto.SuccesResponse;

//@Entity
@Component("MtSwapCommand")
@Scope(value = "prototype")

public class MtSwapCommand extends Command {

	private BigDecimal mtId;

	private BigDecimal newSatEsn;

	private BigDecimal the_service_id = BigDecimal.valueOf(9015);

	public BigDecimal getMtId() {
		return mtId;
	}

	public void setMtId(BigDecimal mtId) {
		this.mtId = mtId;
	}

	public BigDecimal getNewSatEsn() {
		return newSatEsn;
	}

	public void setNewSatEsn(BigDecimal newSatEsn) {
		this.newSatEsn = newSatEsn;
	}

	public MtSwapCommand mtId(BigDecimal mtId) {
		this.mtId = mtId;
		return this;
	}

	public MtSwapCommand newSatEsn(BigDecimal newSatEsn2) {
		this.newSatEsn = newSatEsn2;
		return this;
	}

	@Override
	protected Object executeInternal() throws Exception {

		// TODO Auto-generated method stub
		int CS_SO_TYP = 2;

		// TODO find login
		String the_login_dist_id = "TMIC";

		String sqlSelectSOType = "SELECT billing_state,dist_bill_account_id,subscriber_prov,"
				+ "       subscriber_timezone,sat_esn,so_type,sp_mt_ref,"
				+ "       mt_commanded_state,dh_mt_commanded_state" 
				+ " FROM  web_generic_mt_request_v"
				+ " WHERE mt_id         = ?" + " AND   login_dist_id = ?";

		List<Map<String, Object>> getMtInformationRows = jdbcMs.queryForList(sqlSelectSOType, mtId, the_login_dist_id);

		if (getMtInformationRows.isEmpty()) {
			throw new BadCommandDataException("WEBA-20022: Error - there is no data in MT Information for MT " + mtId);
		}

		Map<String, Object> row = getMtInformationRows.get(0);

		BigDecimal the_dist_bill_account_id = (BigDecimal) row.get("dist_bill_account_id");
		BigDecimal the_sat_esn = (BigDecimal) row.get("sat_esn");
		String the_so_type = (String) row.get("so_type");
		BigDecimal the_billing_state = ((BigDecimal) row.get("billing_state"));
		int the_sp_msg_type = CS_SO_TYP;
		BigDecimal the_mt_commanded_state = ((BigDecimal) row.get("mt_commanded_state"));

		String the_sp_mt_ref = (String) row.get("sp_mt_ref");
		String the_subscriber_prov = (String) row.get("subscriber_prov");
		BigDecimal the_subscriber_timezone = (BigDecimal) row.get("subscriber_timezone");

		if (the_billing_state.longValue() == 2) {
			throw new BadCommandDataException(
					"WEBA-20112: Error - this MT is suspended. Cannot order service " + the_service_id + ".");
		}
		if (the_billing_state.longValue() == 3) {
			throw new BadCommandDataException(
					"WEBA-20114: Error - this MT is disconnected. Cannot order service " + the_service_id + ".");
		}
		
				
		if (the_mt_commanded_state != null && the_mt_commanded_state.longValue() == 2) {
			throw new BadCommandDataException(
					"WEBA-20118: Error - this MT is Operational. Cannot order service.");
		}
	
		String sqlSelect1 = "SELECT sp_ext_sequence_number,dist_id,sp_system_id,sp_user_id"
				+ " FROM  web_spi_current_sessions_log_v" + " WHERE login_dist_id        = ?"
				+ " AND   dist_bill_account_id = ?" + " FOR UPDATE OF sp_ext_sequence_number";

		List<Map<String, Object>> getSpiCurrentSessionRows = jdbcMs.queryForList(sqlSelect1, the_login_dist_id,
				the_dist_bill_account_id);

		if (getSpiCurrentSessionRows.isEmpty()) {
			throw new BadCommandDataException(
					"WEBA-20025: Error - there is no record in SPI Current Sessions for Dist " + mtId);
		}

		Map<String, Object> rowSpi = getSpiCurrentSessionRows.get(0);

		BigDecimal the_msg_id = ((BigDecimal) rowSpi.get("sp_ext_sequence_number"));
		String the_mt_dist_id = (String) rowSpi.get("dist_id");
		String the_sp_system_id = (String) rowSpi.get("sp_system_id");
		String the_sp_user_id = (String) rowSpi.get("sp_user_id");

		String sqlSelectProv = "SELECT location_name,location_prov" + " FROM  web_default_location"
				+ " WHERE dist_id = ?";

		List<Map<String, Object>> getSelectProvRows = jdbcMs.queryForList(sqlSelectProv, the_login_dist_id);

		Map<String, Object> rowSelectProv = getSelectProvRows.get(0);

		String the_location_name = (String) rowSelectProv.get("location_name");
		String the_location_prov = (String) rowSelectProv.get("location_prov");

		if (getSelectProvRows.isEmpty()) {
			the_location_name = "OTTAWA";
			the_location_prov = "ON";
		}

		String sqlUpdate = "UPDATE spi_current_sessions_log" + " SET   sp_ext_sequence_number = ?"
				+ " WHERE dist_id      = ?" + " AND   sp_system_id = ?";
		jdbcMs.update(sqlUpdate,  (the_msg_id.add(BigDecimal.valueOf(1))), the_mt_dist_id, the_sp_system_id);

		String sqlInsert1 = "INSERT INTO spi_inbound_log"
				+ "(sp_msg_id,dist_id,sp_system_id,sp_msg_timestamp,sp_user_id,sp_msg_type)" + "VALUES (?,?,?,?,?,?)";

		Date time = new java.sql.Date(new java.util.Date().getTime());
		jdbcMs.update(sqlInsert1, the_msg_id, the_mt_dist_id, the_sp_system_id, time, the_sp_user_id, the_sp_msg_type);

		String sqlInsert = "INSERT INTO cs_service_request" + "( sp_msg_id,dist_id,sp_system_id,dist_bill_account_id,"
				+ "  sp_so_ref,service_id,created_dt,rtin,mt_id,sp_mt_ref,"
				+ "  subscriber_prov,subscriber_timezone,processed_flag,"
				+ "  so_rqst_cs_param_1,so_rqst_cs_param_2,so_rqst_cs_param_3)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		jdbcMs.update(sqlInsert, the_msg_id, the_mt_dist_id, the_sp_system_id, the_dist_bill_account_id,
				the_login_dist_id, the_service_id, time, the_sat_esn, mtId, the_sp_mt_ref, the_subscriber_prov,
				the_subscriber_timezone, 0, newSatEsn, the_location_name, the_location_prov);

		SuccesResponse result = new SuccesResponse();

		result.spMsgId(the_msg_id).distId(the_mt_dist_id).spSystemId(the_sp_system_id)
				.serviceId(the_service_id ).satEsn(the_sat_esn).mtId(mtId);

		return result;
	}

	@Override
	public Object fillAndValidate() {
		// TODO Auto-generated method stub
		return super.fillAndValidate();
	}

}
