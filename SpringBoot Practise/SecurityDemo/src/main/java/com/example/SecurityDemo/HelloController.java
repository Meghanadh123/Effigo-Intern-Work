package com.example.SecurityDemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	
		@GetMapping("/hello")
		public String hello()
		{
			return "hello";
		}
		
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/user")
		public String userEndPoint()
		{
			return "hello, user";
		}
		
		@PreAuthorize("hasRole('ADMIN')")
		@GetMapping("/admin")
		public String adminEndPoint()
		{
			return "hello, admin";
		}
}
