package com.ligado.api.domain.query;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CircuitSwitchMsIdDomain {

	@JsonProperty("sp_msg_id")
	private String spMsgId;

	@JsonProperty("the_sp_so_type")
	private String theSpSoType;

	@JsonProperty("sp_so_ref")
	private String spSoRef;

	@JsonProperty("sp_mt_ref")
	private String spMtRef;

	@JsonProperty("service_id")
	private String serviceId;

	@JsonProperty("so_id")
	private String soId;

	@JsonProperty("so_ship_timestamp")
	private String soShipTimestamp;

	@JsonProperty("status")
	private String status;

	@JsonProperty("error_code")
	private String errorCode;

	@JsonProperty("error_text")
	private String errorText;

	@JsonProperty("dist_id")
	private String distId;

	@JsonProperty("dist_bill_account_id")
	private String distBillAccountId;

	@JsonProperty("mt_id")
	private String mtId;

	@JsonProperty("sat_esn")
	private String satEsn;

	@JsonProperty("mt_state")
	private String mtState;

	@JsonProperty("mt_sask")
	private String mtSask;

	@JsonProperty("commissioning_frequency")
	private Double commissioningFrequency;

	@JsonProperty("pilot_frequency")
	private Double pilotFrequency;

	@JsonProperty("telephone_number")
	private String telephoneNumber;

	public CircuitSwitchMsIdDomain spMsgId(String spMsgId) {
		this.spMsgId = spMsgId;
		return this;
	}

	/**
	 * sp_msg_id
	 * 
	 * @return spMsgId
	 */

	public String getSpMsgId() {
		return spMsgId;
	}

	public void setSpMsgId(String spMsgId) {
		this.spMsgId = spMsgId;
	}

	public CircuitSwitchMsIdDomain theSpSoType(String theSpSoType) {
		this.theSpSoType = theSpSoType;
		return this;
	}

	/**
	 * SO Type
	 * 
	 * @return theSpSoType
	 */

	public String getTheSpSoType() {
		return theSpSoType;
	}

	public void setTheSpSoType(String theSpSoType) {
		this.theSpSoType = theSpSoType;
	}

	public CircuitSwitchMsIdDomain spSoRef(String spSoRef) {
		this.spSoRef = spSoRef;
		return this;
	}

	/**
	 * SP SO Reference
	 * 
	 * @return spSoRef
	 */

	public String getSpSoRef() {
		return spSoRef;
	}

	public void setSpSoRef(String spSoRef) {
		this.spSoRef = spSoRef;
	}

	public CircuitSwitchMsIdDomain spMtRef(String spMtRef) {
		this.spMtRef = spMtRef;
		return this;
	}

	/**
	 * SP MT Reference
	 * 
	 * @return spMtRef
	 */

	public String getSpMtRef() {
		return spMtRef;
	}

	public void setSpMtRef(String spMtRef) {
		this.spMtRef = spMtRef;
	}

	public CircuitSwitchMsIdDomain serviceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	/**
	 * Service Id
	 * 
	 * @return serviceId
	 */

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public CircuitSwitchMsIdDomain soId(String soId) {
		this.soId = soId;
		return this;
	}

	/**
	 * Service Order Id
	 * 
	 * @return soId
	 */

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}

	public CircuitSwitchMsIdDomain soShipTimestamp(String soShipTimestamp) {
		this.soShipTimestamp = soShipTimestamp;
		return this;
	}

	/**
	 * SO Ship Timestamp
	 * 
	 * @return soShipTimestamp
	 */

	public String getSoShipTimestamp() {
		return soShipTimestamp;
	}

	public void setSoShipTimestamp(String soShipTimestamp) {
		this.soShipTimestamp = soShipTimestamp;
	}

	public CircuitSwitchMsIdDomain status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Service Order Status
	 * 
	 * @return status
	 */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CircuitSwitchMsIdDomain errorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	/**
	 * Error Code
	 * 
	 * @return errorCode
	 */

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public CircuitSwitchMsIdDomain errorText(String errorText) {
		this.errorText = errorText;
		return this;
	}

	/**
	 * Error Text
	 * 
	 * @return errorText
	 */

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public CircuitSwitchMsIdDomain distId(String distId) {
		this.distId = distId;
		return this;
	}

	/**
	 * Distributor Id
	 * 
	 * @return distId
	 */

	public String getDistId() {
		return distId;
	}

	public void setDistId(String distId) {
		this.distId = distId;
	}

	public CircuitSwitchMsIdDomain distBillAccountId(String distBillAccountId) {
		this.distBillAccountId = distBillAccountId;
		return this;
	}

	/**
	 * Billing Account
	 * 
	 * @return distBillAccountId
	 */

	public String getDistBillAccountId() {
		return distBillAccountId;
	}

	public void setDistBillAccountId(String distBillAccountId) {
		this.distBillAccountId = distBillAccountId;
	}

	public CircuitSwitchMsIdDomain mtId(String mtId) {
		this.mtId = mtId;
		return this;
	}

	/**
	 * MT Id
	 * 
	 * @return mtId
	 */

	public String getMtId() {
		return mtId;
	}

	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	public CircuitSwitchMsIdDomain satEsn(String satEsn) {
		this.satEsn = satEsn;
		return this;
	}

	/**
	 * Sat ESN
	 * 
	 * @return satEsn
	 */

	public String getSatEsn() {
		return satEsn;
	}

	public void setSatEsn(String satEsn) {
		this.satEsn = satEsn;
	}

	public CircuitSwitchMsIdDomain mtState(String mtState) {
		this.mtState = mtState;
		return this;
	}

	/**
	 * MT Commanded State
	 * 
	 * @return mtState
	 */

	public String getMtState() {
		return mtState;
	}

	public void setMtState(String mtState) {
		this.mtState = mtState;
	}

	public CircuitSwitchMsIdDomain mtSask(String mtSask) {
		this.mtSask = mtSask;
		return this;
	}

	/**
	 * MT SASK
	 * 
	 * @return mtSask
	 */

	public String getMtSask() {
		return mtSask;
	}

	public void setMtSask(String mtSask) {
		this.mtSask = mtSask;
	}

	public CircuitSwitchMsIdDomain commissioningFrequency(Double commissioningFrequency) {
		this.commissioningFrequency = commissioningFrequency;
		return this;
	}

	/**
	 * Commissioning Frequency
	 * 
	 * @return commissioningFrequency
	 */

	public Double getCommissioningFrequency() {
		return commissioningFrequency;
	}

	public void setCommissioningFrequency(Double commissioningFrequency) {
		this.commissioningFrequency = commissioningFrequency;
	}

	public CircuitSwitchMsIdDomain pilotFrequency(Double pilotFrequency) {
		this.pilotFrequency = pilotFrequency;
		return this;
	}

	/**
	 * Pilot Frequency
	 * 
	 * @return pilotFrequency
	 */

	public Double getPilotFrequency() {
		return pilotFrequency;
	}

	public void setPilotFrequency(Double pilotFrequency) {
		this.pilotFrequency = pilotFrequency;
	}

	public CircuitSwitchMsIdDomain telephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
		return this;
	}

	/**
	 * Account Number
	 * 
	 * @return telephoneNumber
	 */

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CircuitSwitchMsIdDomain circuitSwitchMsId = (CircuitSwitchMsIdDomain) o;
		return Objects.equals(this.spMsgId, circuitSwitchMsId.spMsgId)
				&& Objects.equals(this.theSpSoType, circuitSwitchMsId.theSpSoType)
				&& Objects.equals(this.spSoRef, circuitSwitchMsId.spSoRef)
				&& Objects.equals(this.spMtRef, circuitSwitchMsId.spMtRef)
				&& Objects.equals(this.serviceId, circuitSwitchMsId.serviceId)
				&& Objects.equals(this.soId, circuitSwitchMsId.soId)
				&& Objects.equals(this.soShipTimestamp, circuitSwitchMsId.soShipTimestamp)
				&& Objects.equals(this.status, circuitSwitchMsId.status)
				&& Objects.equals(this.errorCode, circuitSwitchMsId.errorCode)
				&& Objects.equals(this.errorText, circuitSwitchMsId.errorText)
				&& Objects.equals(this.distId, circuitSwitchMsId.distId)
				&& Objects.equals(this.distBillAccountId, circuitSwitchMsId.distBillAccountId)
				&& Objects.equals(this.mtId, circuitSwitchMsId.mtId)
				&& Objects.equals(this.satEsn, circuitSwitchMsId.satEsn)
				&& Objects.equals(this.mtState, circuitSwitchMsId.mtState)
				&& Objects.equals(this.mtSask, circuitSwitchMsId.mtSask)
				&& Objects.equals(this.commissioningFrequency, circuitSwitchMsId.commissioningFrequency)
				&& Objects.equals(this.pilotFrequency, circuitSwitchMsId.pilotFrequency)
				&& Objects.equals(this.telephoneNumber, circuitSwitchMsId.telephoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(spMsgId, theSpSoType, spSoRef, spMtRef, serviceId, soId, soShipTimestamp, status, errorCode,
				errorText, distId, distBillAccountId, mtId, satEsn, mtState, mtSask, commissioningFrequency,
				pilotFrequency, telephoneNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CircuitSwitchMsIdDomain {\n");
		sb.append("    spMsgId: ").append(toIndentedString(spMsgId)).append("\n");
		sb.append("    theSpSoType: ").append(toIndentedString(theSpSoType)).append("\n");
		sb.append("    spSoRef: ").append(toIndentedString(spSoRef)).append("\n");
		sb.append("    spMtRef: ").append(toIndentedString(spMtRef)).append("\n");
		sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
		sb.append("    soId: ").append(toIndentedString(soId)).append("\n");
		sb.append("    soShipTimestamp: ").append(toIndentedString(soShipTimestamp)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
		sb.append("    errorText: ").append(toIndentedString(errorText)).append("\n");
		sb.append("    distId: ").append(toIndentedString(distId)).append("\n");
		sb.append("    distBillAccountId: ").append(toIndentedString(distBillAccountId)).append("\n");
		sb.append("    mtId: ").append(toIndentedString(mtId)).append("\n");
		sb.append("    satEsn: ").append(toIndentedString(satEsn)).append("\n");
		sb.append("    mtState: ").append(toIndentedString(mtState)).append("\n");
		sb.append("    mtSask: ").append(toIndentedString(mtSask)).append("\n");
		sb.append("    commissioningFrequency: ").append(toIndentedString(commissioningFrequency)).append("\n");
		sb.append("    pilotFrequency: ").append(toIndentedString(pilotFrequency)).append("\n");
		sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
