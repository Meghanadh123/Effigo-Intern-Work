package com.practiseSpring.learn_spring_framework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practiseSpring.learn_spring_framework.game.GamingConsole;
import com.practiseSpring.learn_spring_framework.game.gameRunner;
import com.practiseSpring.learn_spring_framework.game.marioGame;

record Person(String name,int age) {}

@Configuration
public class GamingConfiguration {
    
	@Bean
	public marioGame game()
	{
		marioGame mg= new marioGame();
		return mg;
	}
	
	@Bean
	public gameRunner gameRunner(marioGame game) {
		gameRunner gm=new gameRunner(game);
		return gm;
	}
		
	


}
