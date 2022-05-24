// Stanford 106A
// Assignment 01 - Problem 2 
// https://see.stanford.edu/materials/icspmcs106a/07-assignment-1-karel.pdf

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

  public void run() {
		restoreColumn();
		while (frontIsClear()) {
			longJump();
			restoreColumn();
		}
	}
	
	private void restoreColumn() {
		turnLeft();
		while(frontIsClear()) {
			fixStone();
			move();
		}
		fixStone();
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	private void longJump() {
		for (int i = 0; i < 4; i++) {
			move();
		}
	}
	
	private void fixStone() {
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
}