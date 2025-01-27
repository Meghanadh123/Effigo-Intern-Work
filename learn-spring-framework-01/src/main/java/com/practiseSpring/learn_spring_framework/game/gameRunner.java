package com.practiseSpring.learn_spring_framework.game;

public class gameRunner {
		marioGame game;
		public gameRunner(marioGame game)
		{
			this.game=game;
			
		}
		public void run() {
			System.out.println("Running game"+ game);
			game.up();
			game.down();
			game.left();
			game.right();
}
}
