package com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig /*in older we were extends our class to WebsecurityConfigureAdapter but now its depricated*/  {
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		User.UserBuilder users= User.withDefaultPasswordEncoder();
		UserDetails userDetails1=users
								.username("testuser1")
								.password("testapi1")
								.roles("user")
								.build();
//		adding one more user
		UserDetails userDetails2=users
				.username("testuser2")
				.password("testapi2")
				.roles("user")
				.build();
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests(
				(req) -> req
						.requestMatchers("/department/checksFilter","/department/createDepartment").permitAll()
//						.anyRequest().authenticated()
				).formLogin();
		return httpSecurity.build();
	}
}
