package com.ligado.api.service.impl;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ligado.api.domain.Command;
import com.ligado.api.exception.MsException;
import com.ligado.api.service.Service;

@org.springframework.stereotype.Service
public class AsyncExecutionService implements Service {

	private final Log log = LogFactory.getLog(this.getClass());
	@Autowired protected JdbcTemplate jdbcMs;
	@Autowired protected DataSource datasource;
	

	
	@Override
	public Object execute(Command command) throws MsException {
		log.info("executing command asynchronously ");
		try {
			command.setJdbcMs(jdbcMs);
			return command.execute();
		} catch (Exception e) {
			throw new MsException(e);
		}	
		}

}
