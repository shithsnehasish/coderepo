/**
 * 
 */
package com.dell.glit.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String role = request.getParameter("role");
       request.getSession().setAttribute("role", role);

        return super.attemptAuthentication(request, response); 
    } 
	
}