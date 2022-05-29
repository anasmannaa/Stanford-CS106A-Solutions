/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

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
