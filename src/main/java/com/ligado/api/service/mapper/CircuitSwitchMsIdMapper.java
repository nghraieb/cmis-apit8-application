package com.ligado.api.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ligado.api.domain.SuccesResponseDomain;
import com.ligado.api.domain.query.CircuitSwitchMsIdDomain;
import com.ligado.api.service.api.dto.CircuitSwitchMsId;
import com.ligado.api.service.api.dto.SuccesResponse;

@Mapper
public interface CircuitSwitchMsIdMapper {
	
	
		CircuitSwitchMsIdMapper INSTANCE = Mappers.getMapper( CircuitSwitchMsIdMapper.class ); 
	   
	    @Mapping(source = "spMsgId", target = "spMsgId")
	    CircuitSwitchMsId CircuitSwitchMsIdToSuccesResponseDto(CircuitSwitchMsIdDomain circuitSwitchMsId); 

}
