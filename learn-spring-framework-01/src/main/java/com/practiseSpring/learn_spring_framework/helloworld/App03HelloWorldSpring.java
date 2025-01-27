package com.practiseSpring.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practiseSpring.learn_spring_framework.game.gameRunner;

public class App03HelloWorldSpring {
	public static void main(String args[]) {
	
	
	
	try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
	{
		context.getBean(gameRunner.class).run();
	}
}
}
