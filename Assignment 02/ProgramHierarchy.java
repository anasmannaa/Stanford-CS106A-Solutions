
// Stanford 106A
// Assignment 02 - Problem 03
// https://see.stanford.edu/materials/icspmcs106a/13-assignment-2-simple-java.pdf

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	/* Define some parameters */
	private final static double BOX_WIDTH = 180;
	private final static double BOX_HEIGHT = 50;
	private final static double H_GAB = 30;
	
	public void run() {
		drawTopCenterBox();
		drawBottomLeftBox();
		drawBottomCenterBox();
		drawBottomRightBox();
		drawLeftLine();
		drawMiddleLine();
		drawRightLine();
		addTopCenterLabel();
		addBottomLeftLabel();
		addBottomCenterLabel();
		addBottomRightLabel();
	}
	
	private void drawTopCenterBox() {
		double x = (getWidth()/2 - BOX_WIDTH / 2);
		double y = (getHeight()/2 - BOX_HEIGHT * 1.5);
		GRect rect = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(rect);
	}
	
	private void drawBottomCenterBox() {
		double x = (getWidth()/2 - BOX_WIDTH / 2);
		double y = (getHeight()/2 + BOX_HEIGHT * .5);
		GRect rect = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(rect);
	}
	
	private void drawBottomLeftBox() {
		double x = (getWidth()/2 - ((BOX_WIDTH * 1.5) + H_GAB));
		double y = (getHeight()/2 + BOX_HEIGHT * .5);
		GRect rect = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(rect);
	}
	
	private void drawBottomRightBox() {
		double x = (getWidth()/2 + ((BOX_WIDTH * .5) + H_GAB));
		double y = (getHeight()/2 + BOX_HEIGHT * .5);
		GRect rect = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(rect);
	}
	
	private void drawLeftLine() {
		double x1 = getWidth()/2;
		double y1 = (getHeight()/2 - BOX_HEIGHT * .5);
		double x2 = (getWidth()/2 - (BOX_WIDTH  + H_GAB));
		double y2 = (getHeight()/2 + BOX_HEIGHT * .5);
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}
	
	private void drawMiddleLine() {
		double x1 = getWidth()/2;
		double y1 = (getHeight()/2 - BOX_HEIGHT * .5);
		double y2 = (getHeight()/2 + BOX_HEIGHT * .5);
		GLine line = new GLine(x1, y1, x1, y2);
		add(line);
	}
	
	private void drawRightLine() {
		double x1 = getWidth()/2;
		double y1 = (getHeight()/2 - BOX_HEIGHT * .5);
		double x2 = (getWidth()/2 + (BOX_WIDTH  + H_GAB));
		double y2 = (getHeight()/2 + BOX_HEIGHT * .5);
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}
	
	private void addTopCenterLabel() {
		GLabel label = new GLabel("Program");
		double x = getWidth()/2 - label.getWidth()/2;
		double y = getHeight()/2 - BOX_HEIGHT + label.getHeight()/2;
		add(label, x, y);
	}
	
	private void addBottomCenterLabel() {
		GLabel label = new GLabel("Console");
		double x = getWidth()/2 - label.getWidth()/2;
		double y = getHeight()/2 + BOX_HEIGHT + label.getHeight()/2;
		add(label, x, y);
	}
	
	private void addBottomLeftLabel() {
		GLabel label = new GLabel("Graphics");
		double x = getWidth()/2 - H_GAB - BOX_WIDTH - (label.getWidth()/2);
		double y = getHeight()/2 + BOX_HEIGHT + label.getHeight()/2;
		add(label, x, y);
	}
	
	private void addBottomRightLabel() {
		GLabel label = new GLabel("Graphics");
		double x = getWidth()/2 + H_GAB + BOX_WIDTH - (label.getWidth()/2);
		double y = getHeight()/2 + BOX_HEIGHT + label.getHeight()/2;
		add(label, x, y);
	}
}
