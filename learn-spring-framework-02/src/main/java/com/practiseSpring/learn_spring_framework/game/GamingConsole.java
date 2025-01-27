package com.practiseSpring.learn_spring_framework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GamingConsole {
	
	@Bean
	public void up()
	{
		System.out.println("up");
	}
}
