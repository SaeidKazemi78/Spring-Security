package com.techprimers.security.securitydbexample.config;

import java.io.IOException;
import java.util.Collection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techprimers.security.securitydbexample.model.Users;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        boolean hasUserRole = false;
        boolean hasAdminRole = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("Here is all authorities for : "+authentication.getPrincipal().toString() + "are  " + authentication.getAuthorities());

        for (GrantedAuthority gauth : authorities) {
            if (gauth.getAuthority().equals("ROLE_USER")) {
                hasUserRole = true;
                break;
            } else if (gauth.getAuthority().equals("ROLE_ADMIN")) {
                hasAdminRole = true;
                break;
            }
        }

        
		if (hasUserRole) {
			redirectStrategy.sendRedirect(request,response, "/user?username="+ authentication.getName());//if user with role 'user' athenticates he/she will redirect to 'user' page
		} else if (hasAdminRole) {
			redirectStrategy.sendRedirect(request, response, "/admin");//if user with role 'admin' athenticates he/she will redirect to 'admin' page
		} else {
			redirectStrategy.sendRedirect(request, response, "/");//if the user does not have one of those roles  he will redirect to 'home' page 
			
		}

    }

}