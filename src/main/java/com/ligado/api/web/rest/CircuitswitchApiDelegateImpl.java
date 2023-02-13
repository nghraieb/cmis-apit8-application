package com.ligado.api.web.rest;

import java.math.BigDecimal;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ligado.api.domain.MtSwapCommand;
import com.ligado.api.domain.SuccesResponseDomain;
import com.ligado.api.domain.query.CircuitSwitchMsIdDomain;
import com.ligado.api.domain.query.GetRequestByMsIdQuery;
import com.ligado.api.exception.MsException;
import com.ligado.api.security.SecurityUtils;
import com.ligado.api.domain.Command;
import com.ligado.api.service.Service;
import com.ligado.api.service.api.dto.CircuitSwitchMsId;
import com.ligado.api.service.api.dto.SuccesResponse;
import com.ligado.api.service.mapper.CircuitSwitchMsIdMapper;
import com.ligado.api.service.mapper.SuccesResponseMapper;
import com.ligado.api.web.api.CircuitswitchApiDelegate;

@org.springframework.stereotype.Service
public class CircuitswitchApiDelegateImpl implements CircuitswitchApiDelegate {
	@Autowired
	private Service service;

	@Autowired
	ApplicationContext context;

	@Autowired
	GetRequestByMsIdQuery getRequestByMsIdQuery ;

	@Override
	public ResponseEntity<SuccesResponse> mTSwap(Float mtId, Float newSatEsn) {

		Command command = FillCommandFromInput(BigDecimal.valueOf(mtId), BigDecimal.valueOf(newSatEsn));

		SuccesResponse result = null;
		SuccesResponseDomain succesResponse;
		try {
			succesResponse = (SuccesResponseDomain) service.execute(command);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(result);

		}
		
		result =SuccesResponseMapper.INSTANCE.SuccesResponseToSuccesResponseDto(succesResponse) ;
		MDC.clear();
		return ResponseEntity.accepted().body(result);

	}

	private Command FillCommandFromInput(BigDecimal mtId, BigDecimal newSatEsn) {

		MtSwapCommand command = new MtSwapCommand();//(MtSwapCommand) context.getBean("MtSwapCommand");
		
		String the_login_dist_id = SecurityUtils.getCurrentUserLogin().get();

		return command.mtId(mtId).newSatEsn(newSatEsn).loginDistId(the_login_dist_id);
	}
	
	
	@Override
	public ResponseEntity<CircuitSwitchMsId> findBySpMsgId(Float spMsgId) {
		// TODO Auto-generated method stub
		getRequestByMsIdQuery = fillGetRequestByMsIdQuery(spMsgId) ;
		CircuitSwitchMsId result=null;
		CircuitSwitchMsIdDomain circuitSwitchMsIdDomain=null;
		try {
			 circuitSwitchMsIdDomain = (CircuitSwitchMsIdDomain) getRequestByMsIdQuery.execute();
		} catch (MsException e) {
			return ResponseEntity.badRequest().body(result);

		}
		
		result =CircuitSwitchMsIdMapper.INSTANCE.CircuitSwitchMsIdToSuccesResponseDto(circuitSwitchMsIdDomain) ;
		
		MDC.clear();
		return  ResponseEntity.ok().body(result) ;
	}

	private GetRequestByMsIdQuery fillGetRequestByMsIdQuery(Float spMsgId) {
		String the_login_dist_id = SecurityUtils.getCurrentUserLogin().get();
		getRequestByMsIdQuery.setSpMsgId(spMsgId);
		getRequestByMsIdQuery.setDistId(the_login_dist_id);
		return getRequestByMsIdQuery;
	}
}
