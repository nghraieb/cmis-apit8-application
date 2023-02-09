package com.ligado.api.security;

import com.ligado.api.domain.Authority;
import com.ligado.api.domain.User;
import com.ligado.api.repository.UserRepository;
import java.util.*;
import java.util.stream.Collectors;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepository userRepository;
    
	@Autowired protected JdbcTemplate jdbcMs;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);

      /*    if (new EmailValidator().isValid(login, null)) {
            return userRepository
                .findOneWithAuthoritiesByEmailIgnoreCase(login)
                .map(user -> createSpringSecurityUser(login, user))
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
        }

        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        return userRepository
            .findOneWithAuthoritiesByLogin(lowercaseLogin)
            .map(user -> createSpringSecurityUser(lowercaseLogin, user))
            .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

            *
            *
            */  List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        
        GrantedAuthority grantedAuthorityAdmin=new SimpleGrantedAuthority("ROLE_ADMIN");
        GrantedAuthority grantedAuthorityUser=new SimpleGrantedAuthority("ROLE_USER");
        
        grantedAuthorities.add(grantedAuthorityUser);
        grantedAuthorities.add(grantedAuthorityAdmin);
        
        String sqlSelectSOType = "SELECT password " 
				+ " FROM    webactivation_users_v "
				+ "    WHERE  dist_id = ? "
				+ "    AND    status IN (1,2,3,4) ";

		String userGetPassword;
		try {
			userGetPassword = jdbcMs.queryForObject(sqlSelectSOType,String.class, login);
		} catch (DataAccessException e) {
			throw new UsernameNotFoundException("User " + login + " was not found in the database");
		}
		return new org.springframework.security.core.userdetails.User(login, userGetPassword, grantedAuthorities);
       
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = user
            .getAuthorities()
            .stream()
            .map(Authority::getName)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}
