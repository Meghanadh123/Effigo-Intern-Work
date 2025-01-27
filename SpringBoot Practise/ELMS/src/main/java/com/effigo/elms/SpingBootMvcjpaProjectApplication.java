package com.effigo.elms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.effigo.elms"})
public class SpingBootMvcjpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootMvcjpaProjectApplication.class, args);
		System.out.println("Employee Leave Management System using SpringBoot JPA");
	}

}
