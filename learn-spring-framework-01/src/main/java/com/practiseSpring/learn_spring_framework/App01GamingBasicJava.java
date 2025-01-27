package com.practiseSpring.learn_spring_framework;

import com.practiseSpring.learn_spring_framework.game.gameRunner;
import com.practiseSpring.learn_spring_framework.game.marioGame;

public class App01GamingBasicJava {
	public static void main(String args[])
	{
		var  mg=new marioGame();
		var gr =new gameRunner(mg);
		gr.run();
		
		
	}
}
