package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	private int score = 0;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
	    snake = new Snake();
	    food = new Food();
	}
	
	public void play() {
	    while (snake.isInbounds()) { //in snake.java
	        int dir = getKeypress();
	        
	        //Only change direction if a key is pressed
	        if (dir != -1) {
	            snake.changeDirection(dir);
	        }
	        
	        snake.move();

	        if (snake.eatFood(food)) {
	            food = new Food();  // replace eaten food
	            score++; //increase score
	        }

	        updateDrawing();
	    }

	    System.out.println("Game Over!");
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
	
	private void showIntroScreen() {
	    StdDraw.clear();
	    StdDraw.setPenColor(Color.BLACK);
	    StdDraw.text(0.5, 0.6, "~>°)～～～ Welcome to The Snake Game ~>°)～～～ ");
	    StdDraw.text(0.5, 0.5, "Use WASD to move");
	    StdDraw.text(0.5, 0.4, "Press SPACE to start");
	    StdDraw.show();

	    // Wait until space is pressed
	    while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
	        StdDraw.pause(10);
	    }

	    // Wait for them to let go of space so game doesn't start instantly
	    while (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
	        StdDraw.pause(10);
	    }
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
	    StdDraw.clear();
	    snake.draw();
	    food.draw();
	    
	    StdDraw.setPenColor(Color.BLACK);
	    StdDraw.textLeft(0.02, 0.98, "Score: " + score);
	    
	    StdDraw.pause(50);
	    StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.showIntroScreen(); 
		g.play();
	}
}
