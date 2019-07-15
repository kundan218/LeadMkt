package com.jspl.lms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspl.lms.configuration.security.CustomAuthenticationSuccessHandler;
import com.jspl.lms.model.User;
import com.jspl.lms.model.UserRole;
import com.jspl.lms.service.UserService;
import com.jspl.lms.util.CommonUtils;



@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
   private PasswordEncoder passwordEncoder;
	
	@Autowired
	protected AuthenticationManager authenticationManager;
	
	@Autowired
	CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	

	

	/**
	 * This method handles Access-Denied redirect.
	 * @author Mk
	 */
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * @author Mk 
	 */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, HttpSession session,User user) {
		System.out.println("Login Page");
		
		return "/login";
	    
	}

	/**
	 * This method handles logout requests.
	 * @author Mk
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 * @author Mk
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method is used to sign up new user
	 * @author Mk
	 */
	@RequestMapping(value="/new-user-sign-up")
	public String newUserSignUp(HttpServletRequest request,HttpServletResponse response,HttpSession session, @Valid User user, BindingResult result,ModelMap model){
		try {
			if (result.hasErrors()) {
				return "redirect:/login";
			}
			
			if(!userService.isUserUniqueByUserName(user.getUsername())){
				FieldError ssoError =new FieldError("user","username",messageSource.getMessage("non.unique.ssoId", new String[]{user.getUsername()}, Locale.getDefault()));
			    result.addError(ssoError);
				return "redirect:/login";
			}
			
			UserRole userRole = new UserRole();
			userRole.setRoleId(4);
			List<UserRole> rolelist = new ArrayList<UserRole>();
			rolelist.add(userRole);
			user.setUserRole(rolelist);
			user.setStatus(0);
			user.setRegisteredDate(new Date());
	
			if (userService.saveUser(user) != 0){
				request.login(user.getUsername(), user.getPassword());
			} 
			
		}catch (Exception e) {
				e.printStackTrace();
			}
		
		return "";
		
	}


	/**
	 * @author Mk
	 */
	@RequestMapping(value="/forgetPassword", method = RequestMethod.POST)
	 @ResponseBody 
	public String forgetPassword(@RequestParam(value ="email", required=true) String emailId){
		
		System.out.println(emailId+"emailId");
		String password = CommonUtils.generateRandomString();
	
		String encPassword=passwordEncoder.encode(password);
		System.out.println(password+"password");
		System.out.println(encPassword+"encPassword");
		int count=userService.forgetPassword(encPassword,emailId);
		System.out.println("sumit");
			try {
				CommonUtils.sentMailForPassword(emailId, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return "login";
	}	
	
	@RequestMapping(value="/changePassword", method = RequestMethod.POST)
	 
	public String changePassword(@RequestParam(value ="password", required=true) String password,
			@RequestParam(value ="username", required=true) String username){
		
	
	
		String encPassword=passwordEncoder.encode(password);
		
		
		userService.changePassword(encPassword,username);
	
			
		
		
		return "/login";
	}	
}