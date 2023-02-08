package com.ligado.api.web.rest;

import java.math.BigDecimal;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ligado.api.domain.MtSwapCommand;
import com.ligado.api.domain.Command;
import com.ligado.api.service.Service;
import com.ligado.api.service.api.dto.SuccesResponse;
import com.ligado.api.web.api.CircuitswitchApiDelegate;
@org.springframework.stereotype.Service
public class CircuitswitchApiDelegateImpl implements CircuitswitchApiDelegate {
	@Autowired
	private Service service;

	@Autowired
	ApplicationContext context;

	@Override
	public ResponseEntity<SuccesResponse> mTSwap(Float mtId, Float newSatEsn) {

		Command command = FillCommandFromInput(BigDecimal.valueOf(mtId), BigDecimal.valueOf(newSatEsn));

		SuccesResponse result = null;
		try {
			result = (SuccesResponse) service.execute(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MDC.clear();
		return ResponseEntity.accepted().body(result);

	}

	private Command FillCommandFromInput(BigDecimal mtId, BigDecimal newSatEsn) {

		MtSwapCommand command = new MtSwapCommand();//(MtSwapCommand) context.getBean("MtSwapCommand");
		return command.mtId(mtId).newSatEsn(newSatEsn);
	}
}
