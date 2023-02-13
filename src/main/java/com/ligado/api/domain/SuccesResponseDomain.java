package com.ligado.api.domain;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SuccesResponseDomain  {

		  @JsonProperty("sp_msg_id")
		  private BigDecimal spMsgId;

		  @JsonProperty("dist_id")
		  private String distId;

		  @JsonProperty("sp_system_id")
		  private String spSystemId;

		  @JsonProperty("service_id")
		  private BigDecimal serviceId;

		  @JsonProperty("sat_esn")
		  private BigDecimal satEsn;

		  @JsonProperty("mt_id")
		  private BigDecimal mtId;

		  public SuccesResponseDomain spMsgId(BigDecimal spMsgId) {
		    this.spMsgId = spMsgId;
		    return this;
		  }

		  /**
		   * Message ID key
		   * @return spMsgId
		  */
		  @Valid 
		  @Schema(name = "sp_msg_id", example = "123654", description = "Message ID key", required = false)
		  public BigDecimal getSpMsgId() {
		    return spMsgId;
		  }

		  public void setSpMsgId(BigDecimal spMsgId) {
		    this.spMsgId = spMsgId;
		  }

		  public SuccesResponseDomain distId(String distId) {
		    this.distId = distId;
		    return this;
		  }

		  /**
		   * Dist Id
		   * @return distId
		  */
		  
		  @Schema(name = "dist_id", example = "NIRT", description = "Dist Id", required = false)
		  public String getDistId() {
		    return distId;
		  }

		  public void setDistId(String distId) {
		    this.distId = distId;
		  }

		  public SuccesResponseDomain spSystemId(String spSystemId) {
		    this.spSystemId = spSystemId;
		    return this;
		  }

		  /**
		   * SP System ID
		   * @return spSystemId
		  */
		  
		  @Schema(name = "sp_system_id", example = "NIRTWEB", description = "SP System ID", required = false)
		  public String getSpSystemId() {
		    return spSystemId;
		  }

		  public void setSpSystemId(String spSystemId) {
		    this.spSystemId = spSystemId;
		  }

		  public SuccesResponseDomain serviceId(BigDecimal serviceId) {
		    this.serviceId = serviceId;
		    return this;
		  }

		  /**
		   * Service ID
		   * @return serviceId
		  */
		  @Valid 
		  @Schema(name = "service_id", example = "1040", description = "Service ID", required = false)
		  public BigDecimal getServiceId() {
		    return serviceId;
		  }

		  public void setServiceId(BigDecimal serviceId) {
		    this.serviceId = serviceId;
		  }

		  public SuccesResponseDomain satEsn(BigDecimal satEsn) {
		    this.satEsn = satEsn;
		    return this;
		  }

		  /**
		   * SAT ESN
		   * @return satEsn
		  */
		  @Valid 
		  @Schema(name = "sat_esn", description = "SAT ESN", required = false)
		  public BigDecimal getSatEsn() {
		    return satEsn;
		  }

		  public void setSatEsn(BigDecimal satEsn) {
		    this.satEsn = satEsn;
		  }

		  public SuccesResponseDomain mtId(BigDecimal mtId) {
		    this.mtId = mtId;
		    return this;
		  }

		  /**
		   * Id
		   * @return mtId
		  */
		  @Valid 
		  @Schema(name = "mt_id", description = "Id", required = false)
		  public BigDecimal getMtId() {
		    return mtId;
		  }

		  public void setMtId(BigDecimal mtId) {
		    this.mtId = mtId;
		  }

		  @Override
		  public boolean equals(Object o) {
		    if (this == o) {
		      return true;
		    }
		    if (o == null || getClass() != o.getClass()) {
		      return false;
		    }
		    SuccesResponseDomain succesResponse = (SuccesResponseDomain) o;
		    return Objects.equals(this.spMsgId, succesResponse.spMsgId) &&
		        Objects.equals(this.distId, succesResponse.distId) &&
		        Objects.equals(this.spSystemId, succesResponse.spSystemId) &&
		        Objects.equals(this.serviceId, succesResponse.serviceId) &&
		        Objects.equals(this.satEsn, succesResponse.satEsn) &&
		        Objects.equals(this.mtId, succesResponse.mtId);
		  }

		  @Override
		  public int hashCode() {
		    return Objects.hash(spMsgId, distId, spSystemId, serviceId, satEsn, mtId);
		  }

		  @Override
		  public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("class SuccesResponseDomain {\n");
		    sb.append("    spMsgId: ").append(toIndentedString(spMsgId)).append("\n");
		    sb.append("    distId: ").append(toIndentedString(distId)).append("\n");
		    sb.append("    spSystemId: ").append(toIndentedString(spSystemId)).append("\n");
		    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
		    sb.append("    satEsn: ").append(toIndentedString(satEsn)).append("\n");
		    sb.append("    mtId: ").append(toIndentedString(mtId)).append("\n");
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
