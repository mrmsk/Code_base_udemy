package com.msk.photoapi.users.ms.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.msk.photoapi.users.ms.ui.service.UsersServiceI;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UsersServiceI usersService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private Environment environment;

	public WebSecurity(UsersServiceI usersService, BCryptPasswordEncoder bCryptPasswordEncoder,Environment environment) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.usersService = usersService;
		this.environment=environment;

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/**").permitAll().and().addFilter(getAuthenticationFilter());

	}
	private AuthFilter getAuthenticationFilter() throws Exception
	{
		AuthFilter authenticationFilter = new AuthFilter(usersService, environment, authenticationManager());
		//authenticationFilter.setAuthenticationManager(authenticationManager()); 
		authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
		return authenticationFilter;
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);
    }

}
