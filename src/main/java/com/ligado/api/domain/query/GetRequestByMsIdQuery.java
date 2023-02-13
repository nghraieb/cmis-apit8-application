package com.ligado.api.domain.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ligado.api.service.api.dto.CircuitSwitchMsId;

@Component
public class GetRequestByMsIdQuery extends MsQuery {

	static String CS_SO_TYP = "CS";
	static String NM_SO_TYP = "NM";
	static String PD_SO_TYP = "PD";
	static String GP_SO_TYP = "GP";

	private  Float spMsgId;
	private String distId;
	public void setDistId(String distId) {
		this.distId = distId;
	}

	@Autowired
	private JdbcTemplate jdbcBscs;

	public void setJdbcBscs(JdbcTemplate jdbcBscs) {
		this.jdbcBscs = jdbcBscs;
	}

	private String the_sp_msg_type="CS";

	public void setSpMsgId(Float spMsgId) {
		this.spMsgId = spMsgId;
	}

	@Override
	public CircuitSwitchMsIdDomain executeInternal() {

		
		String l_dist_id = distId;

	/*	context.getAuthentication()
        .getPrincipal();*/

		String sqlSelectSPMsg = "SELECT dist_id,sp_msg_id,dist_bill_account_id,service_id,sp_so_ref,mt_id,"
				+ "       sp_mt_ref,so_id,so_ship_timestamp,error_code,error_text," + "       mt_id,status,mt_state,";

		if (the_sp_msg_type.contentEquals(CS_SO_TYP)) {
			sqlSelectSPMsg = sqlSelectSPMsg + "       commissioning_frequency,so_rspns_cs_param_1 pilot_frequency,"
					+ "       telephone_number,rtin sat_esn,mt_sask" + " FROM  web_cs_service_response_v";
		} // close if

		if (the_sp_msg_type.contentEquals(NM_SO_TYP)){
			sqlSelectSPMsg = sqlSelectSPMsg + "       commissioning_frequency,pilot_frequency,sat_esn,nr_net_id,"
					+ "       nr_net_id_tag,LPAD(nr_mt_dn,4,0) nr_mt_dn,nr_monitor_code,mt_sask"
					+ " FROM  web_nr_memb_service_response_v";
		} // close if

		if (the_sp_msg_type.contentEquals(PD_SO_TYP)) {
			sqlSelectSPMsg = sqlSelectSPMsg + "       commissioning_frequency,x121_address,sat_esn,pilot_frequency,"
					+ "       mui,so_rspns_pd_param_1 new_sat_esn,mt_sask" + " FROM  web_pd_service_response_v";
		} // close if

		if (the_sp_msg_type.contentEquals(GP_SO_TYP)) {
			sqlSelectSPMsg = sqlSelectSPMsg + "       sat_esn,mapping_provider_id,gps_group_id"
					+ " FROM  web_gps_service_response_v";
		} // close if

		sqlSelectSPMsg = sqlSelectSPMsg + " WHERE dist_id   = ?" + " AND   sp_msg_id = ?";

		return jdbcBscs.queryForObject(sqlSelectSPMsg, new Object[] { l_dist_id, spMsgId }, (rs, rowNum) -> {
			return new CircuitSwitchMsIdDomain()
					.theSpSoType(the_sp_msg_type)
					.spMsgId(rs.getString("sp_msg_id"))
					.spSoRef(rs.getString("sp_so_ref"))
					.serviceId(rs.getString("service_id"))
					.soId(rs.getString("so_id"))
					.soShipTimestamp(rs.getString("so_ship_timestamp"))
					.status(rs.getString("status"))
					.errorCode(rs.getString("error_code"))
					.errorText(rs.getString("error_text"))
					.distId(rs.getString("dist_id"))
					.distBillAccountId(rs.getString("dist_bill_account_id"))
					.mtId(rs.getString("mt_id"))
					.satEsn(rs.getString("sat_esn"))
					.mtState(rs.getString("mt_state"))
					.pilotFrequency(rs.getDouble("pilot_frequency"))
					.telephoneNumber(rs.getString("telephone_number"));
		});

		/*
		 * new Object[] {l_dist_id, spMsgId }, (rs, rowNum) -> { return new
		 * CircuitSwitchMsId().spMsgId(rs.getInt("sp_msg_id"))
		 * .distId(rs.getString("snshdes")) .theSpSoType(rs.getString("snshdes"));
		 * 
		 * /*(rs.getString("sp_so_ref")) (rs.getString("sp_mt_ref"))
		 * (rs.getInt("service_id")) (rs.getInt("so_id"))
		 * (rs.getString("so_ship_timestamp")) (rs.getString("status"))
		 * (rs.getString("error_code")) (rs.getString("error_text"))
		 * (rs.getString("dist_id")) (rs.getInt("dist_bill_account_id"))
		 * (rs.getInt("mt_id")) (rs.getInt("sat_esn")) (rs.getString("mt_state"))
		 * (rs.getString("mt_sask")) (rs.getInt("commissioning_frequency"))
		 * (rs.getInt("pilot_frequency")) (rs.getString("telephone_number"))
		 */

	}

}
