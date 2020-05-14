package com.cts.bb.securityconfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	//Authentication : set user/password details and mention the role.
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("jayesh").password("{noop}123").roles("USER").and()
				.withUser("dell").password("{noop}dell123").roles("USER", "ADMIN");
	}

	// Authorization : mention which role can access which URL
	protected void configure(HttpSecurity http) throws Exception
	{
		http.httpBasic().and().authorizeRequests().antMatchers("/userlogin").hasRole("USER")
				.antMatchers("/adminlogin").hasRole("ADMIN")
				.antMatchers("/product/product/").hasRole("ADMIN")
				.antMatchers("/product/product/").hasRole("USER")
				.antMatchers("/product/product/{id}").hasRole("USER")
				.antMatchers("/review/Review/").hasRole("USER")
				.antMatchers("/review/Review/").hasRole("ADMIN")
				.antMatchers("/review/Review/{id}").hasRole("USER")
				.antMatchers("/composite/{id}").hasRole("USER")
				.and().csrf().disable().headers()
				.frameOptions().disable();
	}
	
}
