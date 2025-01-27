package com.effigo.JPAMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.effigo.JPAMapping"})

public class SpringBootJpaMappingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMappingProjectApplication.class, args);
		System.out.println("Spring Boot JPA Relational Mapping Project...!!!");
	}

}
