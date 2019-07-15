/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jspl.lms.configuration.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Mreetunjay 
 * 
 */
@Repository("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /**
     * To determine the target URL, based on ROLE
     *
     * @param authentication
     * @return
     */
    protected String determineTargetUrl(Authentication authentication) {
    	
        boolean isAdmin = false;
        boolean isDistributor = false;
        boolean isSalesMarketing = false;
        boolean isRegionalManager = false;
        boolean isASM = false;
        boolean isSBU = false;
        boolean isSYM = false;
        boolean isZSM = false;
        boolean isNWM = false;
        boolean isEXECUTIVE = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
            	isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_DISTRIBUTOR")) {
            	isDistributor = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_SALES_MARKETING")) {
            	isSalesMarketing = true;
                break;
            }else if(grantedAuthority.getAuthority().equals("ROLE_REGIONAL_MANAGER")){
            	isRegionalManager = true;
            }else if(grantedAuthority.getAuthority().equals("ROLE_ASM")){
            	isASM = true;
            }else if(grantedAuthority.getAuthority().equals("ROLE_SBU")){
            	isSBU = true;
            }else if(grantedAuthority.getAuthority().equals("ROLE_STOCKYARD_MANAGER")){
            	isSYM = true;
            }else if(grantedAuthority.getAuthority().equals("ROLE_ZSM")){
            	isZSM = true;
            }else if(grantedAuthority.getAuthority().equals("ROLE_NWM")){
            	isNWM = true;
            }else if(grantedAuthority.getAuthority().equals("ROLE_EXECUTIVE")){
            	isEXECUTIVE = true;
            }
            
        }

        if (isAdmin) {
            return "/admin/dashboard";
        } else if (isDistributor) {
        	return "/distributor/dashboard";
        }else if (isSalesMarketing) {
        	return "/sales/dashboard";
        } else if(isRegionalManager){
        	return "/rm/dashboard";
    	}else if(isASM){
        	return "/asm/dashboard";
    	}else if(isSBU){
        	return "/sbu/dashboard";
    	}else if(isSYM){
        	return "/sym/dashboard";
    	}else if(isZSM){
        	return "/zsm/dashboard";
    	}else if(isNWM){
        	return "/nwm/dashboard";
    	}else if(isEXECUTIVE){
        	return "/executive/home";
    	}else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
   
}