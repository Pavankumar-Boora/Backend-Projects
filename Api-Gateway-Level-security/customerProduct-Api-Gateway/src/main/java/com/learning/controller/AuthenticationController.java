package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import com.learning.dto.UserDto;
import com.learning.util.JwtTokenUtil;

import org.springframework.security.core.userdetails.User;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDto user) {
    	String encode = bCryptPasswordEncoder.encode(user.getPassword());
    	UserDetails userDetails=User.withUsername(user.getUsername()).password(encode).roles(user.getAuthority()).build();
    	jdbcUserDetailsManager.createUser(userDetails);
        return "Registration successfull for the user "+user.getUsername();
    }

    @PostMapping("/getTokenByLogin")
    public String getTokenByLogin(@RequestBody UserDto user) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtTokenUtil.generateToken(user.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token,@RequestParam("userName") String userName) {
    	jwtTokenUtil.validateToken(token,userName);
        return "Token is valid";
    }
    @GetMapping("/get")
    public String getSomething() {
    	return "Hey am athenticated with Jwt token";
    }
}