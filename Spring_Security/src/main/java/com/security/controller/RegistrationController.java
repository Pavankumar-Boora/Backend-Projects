//package com.security.controller;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RegistrationController {
//
//	@GetMapping("/helloWorld")
//	public String helloWorld() {
//		return "helloworld";
//	}
//	@GetMapping("/hello")
//	public String hello(Authentication authentication) {
//		return "hello "+authentication.getPrincipal();
//	}
//	@GetMapping("/world")
//	public String NoAuthenthication() {
//		return "No Authenthication needed";
//	}
//}
