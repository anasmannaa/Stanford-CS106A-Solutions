// Stanford 106A
// Assignment 01 - Problem 01 
// https://see.stanford.edu/materials/icspmcs106a/07-assignment-1-karel.pdf

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		moveToNewsPaper();
		pickBeeper();
		returnToStartPoint();
	}

	private void moveToNewsPaper() {
		while (frontIsClear()) {
			move();
		}
		turnRight();
		while (leftIsBlocked()) {
			move();
		}
		turnLeft();
		move();	
	}
	
	private void returnToStartPoint() {
		lookBack();
		long1Jump();
		long1Jump();
	}
	
	private void lookBack() {
		turnLeft();
		turnLeft();
	}
	
	private void long1Jump() {
		while(frontIsClear()) {
			move();
		}
		turnRight();
	}
}