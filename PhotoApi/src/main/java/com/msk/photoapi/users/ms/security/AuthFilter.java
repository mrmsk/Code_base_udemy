package com.msk.photoapi.users.ms.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msk.photoapi.users.ms.ui.model.LoginReqModel;
import com.msk.photoapi.users.ms.ui.service.UsersServiceI;

public class AuthFilter extends UsernamePasswordAuthenticationFilter {
	
	
	UsersServiceI usersService;
	
	public AuthFilter(UsersServiceI usersService,  
			AuthenticationManager authenticationManager) {
		this.usersService = usersService;
		super.setAuthenticationManager(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		
		
		try {

			LoginReqModel creds = new ObjectMapper().readValue(req.getInputStream(), LoginReqModel.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	 @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
		 
		 
		 
		 
	 } 
}
