/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * Stanford 106A 
 * Assignment 01 - Problem 04 
 * https://see.stanford.edu/materials/icspmcs106a/07-assignment-1-karel.pdf
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		fillMidPoint();
	}
	
	private void fillMidPoint() {
		fillBorders();
		reposition();
		fillSidesAndMidpoint();
		releaseSides();
		reposition();
		moveToMidPoint();
	}
	
	private void fillBorders() {
		putBeeper();
		while (frontIsClear()) {
			move();
		}
		putBeeper();
	} 
	
	private void fillSidesAndMidpoint() {
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				stepBack();
				if (beepersPresent()) {
					putBeeper();
					break;
				} else {
					putBeeper();
				}
			} 
		}
	}
	
	private void releaseSides() {
		moveToBorder();
		reposition();
		removeAllBeepers();
	}
	
	private void moveToMidPoint() {
		while (noBeepersPresent()) {
			move();
		}
		if (facingWest()) {
			turnAround();
		}
	}
	
	private void reposition() {
		turnAround();
	}
	
	private void stepBack() {
		reposition();
		move();
	}
	
	private void moveToBorder() {
		while(frontIsClear()) {
			move();
		}
	}
	
	private void removeAllBeepers() {
		pickBeeper();
		while (frontIsClear()) {
			move();
			pickBeeper();
		}
	}
	
}
