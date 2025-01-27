package com.effigo.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpingBootHelloWorldProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootHelloWorldProjectApplication.class, args);
		System.out.println("Spring Boot Rest Controller Demo...!!");
	}

}
