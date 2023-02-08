package com.ligado.api.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Transient;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.ligado.api.exception.MsException;
import com.ligado.api.exception.PendingMsCommandException;

public class Command {

	private static final String EVENT_SEPARATOR = ">";

	private static final long serialVersionUID = 1L;

	private static final int EXEC_PATH_MAX = 1000;
	protected static final transient  Logger log = LoggerFactory.getLogger(Command.class);
	@Autowired protected JdbcTemplate jdbcMs;
	@Autowired protected DataSource datasource;
	

	

	public Command() {
		setCreationDate(LocalDateTime.now());
	}


	private void setCreationDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}


	@Transient
	protected String mtId;

	public Object execute() throws Exception  {
		try{
			return executeInternal();
		}catch (Exception e) {
			handleException(e);
		}
		return null;
	}

	public boolean hasPendingOnMs(String mainKey) throws PendingMsCommandException {
		log.debug("checking pending request onMs for key {}", mainKey);
		if (mainKey==null) {
			log.warn("main key is null, so the check pendingRequestOnMs will be ignored");
			return false;
		}
		//TODO write duplication check
		String pendingOnMsQuery = " ";
		List<Map<String, Object>> ids = jdbcMs.queryForList(pendingOnMsQuery, LocalDateTime.now().minusDays(1), mainKey);

		if (!ids.isEmpty()) {
			throw new PendingMsCommandException("command (s) "+ids+"  are still in progress for key "+mainKey)   ;
		} 
		return false;
	}

	
	
	
	private void handleException(Exception e) throws Exception {
		if (e instanceof MsException) {
			throw e;
		}
		throw new MsException(e);
	}

	protected Object executeInternal() throws Exception  {
		return null;
	}

	public Object fillAndValidate() {
		return null;
	}



	public Command mtId(String mtId) {
		this.mtId = mtId;
		return this;
	}

	public void setMsDatasource(DataSource datasource) {
		this.datasource = datasource;
	}


	public void setJdbcMs(JdbcTemplate jdbcMs) {
		this.jdbcMs = jdbcMs;
	}

}
