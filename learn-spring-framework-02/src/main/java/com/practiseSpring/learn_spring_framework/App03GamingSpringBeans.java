package com.practiseSpring.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practiseSpring.learn_spring_framework.game.GamingConsole;
import com.practiseSpring.learn_spring_framework.game.gameRunner;
import com.practiseSpring.learn_spring_framework.game.marioGame;

public class App03GamingSpringBeans {
	public static void main(String args[])
	{
		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		{
			context.getBean(GamingConsole.class).up();
			context.getBean(gameRunner.class).run();;
			
		
		}
			
			
		
		
	}
}
