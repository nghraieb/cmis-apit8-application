package com.ligado.api.service;

import com.ligado.api.domain.Command;
import com.ligado.api.service.api.dto.SuccesResponse;

public interface Service {

	Object execute(Command command) throws Exception;

}
