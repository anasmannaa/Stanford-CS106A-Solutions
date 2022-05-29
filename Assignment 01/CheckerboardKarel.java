// Stanford 106A
// Assignment 01 - Problem 03 
// https://see.stanford.edu/materials/icspmcs106a/07-assignment-1-karel.pdf

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		putBeeper();
		if (frontIsClear()) {
			fillRow();
			turnLeft();
			while (frontIsClear()) {
				buildOdd();
				fillRow();
				turnRight();
				if (frontIsClear()) {
					buildEven();
					fillRow();
					turnLeft();
				}
			}
		} else {
			turnLeft();
			while (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}
	}
	
	private void fillRow() {
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}
	
	private void buildOdd() {
		if (beepersPresent()) {
			move();
			turnLeft();
			move();
			putBeeper();
		} else {
			move();
			putBeeper();
			turnLeft();
		}
	}
	
	private void buildEven() {
		if (beepersPresent()) {
			move();
			turnRight();
			move();
			putBeeper();
		} else {
			move();
			putBeeper();
			turnRight();
		}
	}

}
