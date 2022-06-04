/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
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
	
	private void reposition() {
		turnAround();
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
	
	private void moveToMidPoint() {
		while (noBeepersPresent()) {
			move();
		}
		if (facingWest()) {
			turnAround();
		}
	}
}
