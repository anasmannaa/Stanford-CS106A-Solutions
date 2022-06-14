// Stanford 106A
// Assignment 02 - Problem 01
// https://see.stanford.edu/materials/icspmcs106a/13-assignment-2-simple-java.pdf

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		drawPyramid();
	}
	
	private void drawPyramid() {
		int remainRows = BRICKS_IN_BASE;
		int rowGab = BRICK_WIDTH / 2;
		double xStart = (getWidth() / 2) - (BRICK_WIDTH * (BRICKS_IN_BASE/2));
		double yStart = getHeight() + BRICK_HEIGHT;
		int gabFactor;
		while ( remainRows > 0) {
			gabFactor = BRICKS_IN_BASE - remainRows;
			for (int i = 0; i < remainRows; i++) {
				GRect rect = new GRect((gabFactor * rowGab) + xStart + (i * BRICK_WIDTH), getHeight() - gabFactor * BRICK_HEIGHT,  BRICK_WIDTH, BRICK_HEIGHT);
				add(rect);
			}
			remainRows -=1;
		}
	}
}
