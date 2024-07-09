package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.databaseImpl.UserDetailsImpl;
import com.security.dto.UserDto;

@RestController
public class HelloWorldController {
	
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	private PasswordEncoder passwordEncoder;
	private UserDetailsImpl userDetailsImpl;
	
	public HelloWorldController(JdbcUserDetailsManager jdbcUserDetailsManager,PasswordEncoder passwordEncoder,UserDetailsImpl userDetailsImpl) {
		this.passwordEncoder=passwordEncoder;
		this.jdbcUserDetailsManager=jdbcUserDetailsManager;
		this.userDetailsImpl=userDetailsImpl;
	}
	
	@GetMapping("/helloworld")
	public String helloWorld(Authentication authentication) {
		return "hello-world "+authentication.getPrincipal();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from learning platform";
	}
	@GetMapping("/world")
	public String World() {
		return "Hello from Spring security";
	}
	
	@PostMapping(value = "/process-registration",consumes = "application/json" )
	public String processRegistration(@RequestBody UserDto user) {
		
		String encodedPassword=passwordEncoder.encode(user.getPassword());
		UserDetails appUser=User.withUsername(user.getName()).password(encodedPassword).roles(user.getRole()).build();
		user.getAddress();
		jdbcUserDetailsManager.createUser(appUser);
		userDetailsImpl.createUserOtherDetails(user.getName(), user.getEmail(), user.getMobileNumber(),user.getAddress());
		return "Registration successfull for the user "+user.getName();
	}
}
