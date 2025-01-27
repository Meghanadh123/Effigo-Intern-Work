package com.effigo.MVCJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.effigo.MVCJPA"})
public class SpingBootMvcjpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootMvcjpaProjectApplication.class, args);
		System.out.println("Spring Boot Web MVC Demo with JPA...!!!");
	}

}
