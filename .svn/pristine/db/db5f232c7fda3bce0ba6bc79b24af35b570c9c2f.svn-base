package com.jspl.lms.configuration.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jspl.lms.model.User;
import com.jspl.lms.model.UserRole;
import com.jspl.lms.service.UserService;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserService userService;
	
	/*@Autowired
    private AuthenticationManager authenticationManager;*/
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		
		User user = userService.loadUserByUsername(username);
		logger.info("User : {}", user);
		
		if(user==null){
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}else{
				return new com.jspl.lms.model.UserInfo(username, user.getPassword(), true, true, true, true, getGrantedAuthorities(user), user.getUserPkId(), user.getName(), user.getSapId(), user);
				
		}
			/*return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				 true, true, true, true, getGrantedAuthorities(user));*/
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(UserRole userRole : user.getUserRole()){
			logger.info("UserProfile : {}", userRole);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRole().getRoleName()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}
	
}
