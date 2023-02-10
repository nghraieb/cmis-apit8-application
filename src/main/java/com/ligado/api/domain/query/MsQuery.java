package com.ligado.api.domain.query;

import java.time.Instant;
import java.util.UUID;

import com.ligado.api.exception.MsException;



public class MsQuery  {

	private static final long serialVersionUID = 1L;


	public Object execute() throws MsException  {
		try{
			return executeInternal();
		}catch (Exception e) {
			handleException(e);
		}
		return null;
	}

	private void handleException(Exception e) throws MsException {
		throw new MsException(e);
	}

	protected Object executeInternal() {
		return null;
	}

}
