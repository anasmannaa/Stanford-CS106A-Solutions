
// Stanford 106A
// Assignment 02 - Problem 02
// https://see.stanford.edu/materials/icspmcs106a/13-assignment-2-simple-java.pdf

import acm.graphics.*;
import acm.program.*;
import java.awt.*;



public class Target extends GraphicsProgram {

/* Parameters for the drawing */
	private static final double OUTER_RADIUS = 72.0;
	private static final double MIDDLE_RADIUS = OUTER_RADIUS * 0.65;
	private static final double INNER_RADIUS = OUTER_RADIUS * 0.3;

	public void run() {
		drawTarget(getWidth()/2, getHeight() / 2);
	}
	
	private void drawTarget(double cx, double cy) {
		drawCircle(cx, cy, OUTER_RADIUS, Color.RED);
		drawCircle(cx, cy, MIDDLE_RADIUS, Color.WHITE);
		drawCircle(cx, cy, INNER_RADIUS, Color.RED);
	}
	
	private void drawCircle(double cx, double cy, double radius, Color color) {
		double x = cx - radius / 2;
		double y = cy - radius / 2;
		GOval circle = new GOval(x, y, radius, radius);
		circle.setFilled(true);
		circle.setFillColor(color);
		add(circle);
	}
}
