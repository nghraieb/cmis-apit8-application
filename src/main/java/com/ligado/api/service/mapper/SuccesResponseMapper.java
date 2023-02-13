package com.ligado.api.service.mapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.ligado.api.domain.SuccesResponseDomain;
import com.ligado.api.service.api.dto.SuccesResponse;
@Mapper
public interface  SuccesResponseMapper {
	
	
		SuccesResponseMapper INSTANCE = Mappers.getMapper( SuccesResponseMapper.class ); 
	   
	    @Mapping(source = "spMsgId", target = "spMsgId")
	    SuccesResponse SuccesResponseToSuccesResponseDto(SuccesResponseDomain succesResponse); 

}
