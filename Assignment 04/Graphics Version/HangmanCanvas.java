
/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.util.ArrayList;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_DIAM = 72;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	

/** Resets the display so that only the scaffol appears
  * and have bosy parts ready to show up in the right
  * order when user do a guess mistake
  */
	public void reset() {
		removeAll();
		initializeGraphics();
		resetPartsCount();
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold.
 */
	public void noteIncorrectGuess() {
		showNextPersonPart();
		partsCount++;
	}

	
/** Intialize the graphics of the body */
	private void initializeGraphics() {
		
		if (person == null) {
			intializePerson();
			addPerson();
		} else {
			person.removeAll();
			addPerson();
		}
		if (scafold == null) {
			scafold = new GCompound();
			addScafold();
		} else {
			addScafold();
		}
	}
	
/** Create person compound object, with all elements
 * without adding any element to the body itself
 */
	private void intializePerson() {
		person = new GCompound();
		initPersonElements();
	}

/** initialize person's body parts and add
  * the to an array of GObject in the same order
  * that they shows up
  */
	private void initPersonElements () {
		// init head element
		head = new GOval(HEAD_DIAM, HEAD_DIAM);
		personElements.add(head);
		
		//init body element
		body = new GLine(0, 0, 0, BODY_LENGTH);
		personElements.add(body);
		
		// init left arm 
		left_arm_long = new GLine(0, 0, UPPER_ARM_LENGTH, 0);
		personElements.add(left_arm_long);
		left_arm_short = new GLine(0, 0, 0, LOWER_ARM_LENGTH);
		personElements.add(left_arm_short);
		
		//init right arm 
		right_arm_long = new GLine(0, 0, UPPER_ARM_LENGTH, 0);
		personElements.add(right_arm_long);
		right_arm_short = new GLine(0, 0, 0, LOWER_ARM_LENGTH);
		personElements.add(right_arm_short);
		
		//init left_hip
		left_hip = new GLine(0, 0, HIP_WIDTH, 0);
		personElements.add(left_hip);
		
		//init right hip
		right_hip = new GLine(0, 0, HIP_WIDTH, 0);
		personElements.add(right_hip);
		
		//init left_leg
		left_leg = new GLine(0, 0, 0, LEG_LENGTH);
		personElements.add(left_leg);
		left_foot = new GLine(0, 0, FOOT_LENGTH, 0);
		personElements.add(left_foot);
		
		//init right_leg
		right_leg = new GLine(0, 0, 0, LEG_LENGTH);
		personElements.add(right_leg);
		right_foot = new GLine(0, 0, FOOT_LENGTH, 0);
		personElements.add(right_foot);
	}
  
/** show the right part of the body depending
  * on the wrong guess in the right order
  */
	private void showNextPersonPart() {
			switch (partsCount) {
		    case 0:  addHead();
		             break;
		    case 1:  addBody();
		             break;
		    case 2:  addLeftArm();
		             break;
		    case 3:  addRightArm();
		             break;
		    case 4:  addLeftHip();
		             break;
		    case 5:  addRightHip();
		             break;
		    case 6:  addLeftLeg();
		             break;
		    default: addRightLeg();
		             break;
		}
	}
	
/** methods to show up different parts of body */	
	private void addHead() {
		person.add(head, BEAM_LENGTH - HEAD_DIAM / 2, 0);
	}
	
	private void addBody() {
		person.add(body, BEAM_LENGTH, HEAD_DIAM);
	}
	
	private void addLeftArm() {
		person.add(left_arm_long, BEAM_LENGTH - UPPER_ARM_LENGTH,  HEAD_DIAM + ARM_OFFSET_FROM_HEAD);
		person.add(left_arm_short, BEAM_LENGTH - UPPER_ARM_LENGTH, HEAD_DIAM + ARM_OFFSET_FROM_HEAD);
	}
	
	private void addRightArm() {
		person.add(right_arm_long, BEAM_LENGTH, HEAD_DIAM + ARM_OFFSET_FROM_HEAD);
		person.add(right_arm_short, BEAM_LENGTH + UPPER_ARM_LENGTH, HEAD_DIAM + ARM_OFFSET_FROM_HEAD);
	}
	
	private void addLeftHip() {
		person.add(left_hip, BEAM_LENGTH - HIP_WIDTH, HEAD_DIAM + BODY_LENGTH);
	}
	
	private void addRightHip() {
		person.add(right_hip, BEAM_LENGTH, HEAD_DIAM + BODY_LENGTH);
	}
	
	private void addLeftLeg() {
		person.add(left_leg, BEAM_LENGTH - HIP_WIDTH, HEAD_DIAM + BODY_LENGTH);
		person.add(left_foot, BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, HEAD_DIAM + BODY_LENGTH + LEG_LENGTH);
	}
	
	private void addRightLeg() {
		person.add(right_leg, BEAM_LENGTH + HIP_WIDTH, HEAD_DIAM + BODY_LENGTH);	
		person.add(right_foot, BEAM_LENGTH + HIP_WIDTH, HEAD_DIAM + BODY_LENGTH + LEG_LENGTH);
	}	

/** Add scafold compound to the canvas with all
 * the elements represents parts of scafold added
 */
	private void addScafold() {
		int scafoldInitX = (getWidth() - BEAM_LENGTH - UPPER_ARM_LENGTH) / 2;
		int scafoldInitY = ((getHeight() - SCAFFOLD_HEIGHT) / 2);
		add(scafold, scafoldInitX, scafoldInitY);
		scafold_stand = new GLine(0, 0, 0, SCAFFOLD_HEIGHT);
		beam = new GLine(0, 0, BEAM_LENGTH, 0);
		robe = new GLine(0, 0, 0, ROPE_LENGTH);
		scafold.add(scafold_stand);
		scafold.add(beam);
		scafold.add(robe, BEAM_LENGTH, 0);
	}
	
/** add person compound object to the canvas 
 * and keep all its child components ready to be added
 */
	private void addPerson() {
		int personInitX = (getWidth() - BEAM_LENGTH - UPPER_ARM_LENGTH) / 2;
		int personInitY = ((getHeight() - SCAFFOLD_HEIGHT) / 2) + ROPE_LENGTH;
		add(person, personInitX, personInitY);
	}

/** reset the counter of body parts show up order */
	private void resetPartsCount() {
		partsCount = 0;
	}
	
/** init instance variables */	
	private GCompound scafold;
	private GCompound person;
	private GLine scafold_stand;
	private GLine beam;
	private GLine robe;
	private GLine left_arm_long;
	private GLine right_arm_long;
	private GLine left_arm_short;
	private GLine right_arm_short;
	private GLine body;
	private GLine left_hip;
	private GLine right_hip;
	private GLine left_leg;
	private GLine right_leg;
	private GLine left_foot;
	private GLine right_foot;
	private GOval head;
	private ArrayList <GObject> personElements = new ArrayList <GObject>();
	private int partsCount = 0;
}
	
	
