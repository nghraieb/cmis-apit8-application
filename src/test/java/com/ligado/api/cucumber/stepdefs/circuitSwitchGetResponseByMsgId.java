package com.ligado.api.cucumber.stepdefs;

import static com.ligado.api.web.rest.TestUtil.createFormattingConversionService;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.mockito.internal.matchers.CompareTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.ligado.api.security.AuthoritiesConstants;
import com.ligado.api.security.jwt.JWTFilter;
import com.ligado.api.security.jwt.TokenProvider;
import com.ligado.api.web.api.CircuitswitchApiController;
import com.ligado.api.web.rest.errors.ExceptionTranslator;

public class circuitSwitchGetResponseByMsgId {
	private MockMvc contractApiMockMvc;

	@Autowired
	private CircuitswitchApiController circuitswitchApiController;

	protected ResultActions actions;

	@Autowired
	private MappingJackson2HttpMessageConverter jacksonMessageConverter;

	@Autowired
	private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

	@Autowired
	private ExceptionTranslator exceptionTranslator;

	@Autowired
	private Validator validator;
	 

	@Given("A message ID")
	public void createCircuitSwitchRequest() {
		
		
		  UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
		            "TMIC",
		            "TMIC",
		            Collections.singletonList(new SimpleGrantedAuthority(AuthoritiesConstants.USER))
		        );
		  
		  authentication.setDetails(authentication);

		SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
		Collection<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
	    
         
	      securityContext.setAuthentication(authentication);
		SecurityContextHolder.setContext(securityContext);
		contractApiMockMvc = MockMvcBuilders.standaloneSetup(circuitswitchApiController)
				.setCustomArgumentResolvers(pageableArgumentResolver).setControllerAdvice(exceptionTranslator)
				.setConversionService(createFormattingConversionService()).setMessageConverters(jacksonMessageConverter)
				.setValidator(validator).build();

	}

		
	
	@When("I get the response")
	public void i_get_the_created_request() throws Exception {
		

			actions = contractApiMockMvc.perform(
					get("/api/circuitswitch/findBySpMsgId").param("sp_msg_id", "1000"));
			actions.andExpect(status().is(Integer.parseInt("200")));
		
	}
	@Then("I Should have a response")
	public void i_should_have_a_request() throws NumberFormatException, Exception {
		String message = "200";
			actions.andExpect(status().is(Integer.parseInt(message)))
			.andExpect(jsonPath("$.sp_msg_id").exists());

	
	}

}
