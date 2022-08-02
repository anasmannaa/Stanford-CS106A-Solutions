/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	/* Constants for the game */
	private static final int MAX_TEMPS = 8;
	
	/* initializes the canvas and adds it to the
     * window prior to the run method being executed; 
     */
    public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    }
    
    /* The run method starts the excution of the game */
    public void run() {
    	setUp();
    	printWelcome();
    	playTheGame();	
	}
    
    /* setup the game console and canvas */
    private void setUp() {
    	word = getNewWord();
    	dashWord = getDashWord(word);
    	numGuesses = MAX_TEMPS;
    	canvas.reset();
    }
    
    /* prints welcome screen on console at the game start */
    private void printWelcome() {
    	println("Welcome to Hangman!");
    }
    
    /* plays the game and watch the user guesses and checks
     * to see if user guessed the right character, gives new try if user
     * is not out of tries, prints win if user guessed the right word in full,
     * and prints lose if user out of tries */
    private void playTheGame() {
    	while (numGuesses >= 0) {
    		if (numGuesses == 0) {
        		CallLoser();
        		break;
        	}
    		if (dashWord.equals(word)) {
    			printWin();
    			break;
    		}
    		giveNewTry();
    	}
    }
    
    private void giveNewTry() {
    	String guessed;
    	println("The word now looks like this: " + dashWord);
    	println("You have " + numGuesses + " left.");
    	guessed = readLine("Your Guess: ").toUpperCase();
    	if(word.contains(guessed)) {
    		callRight(guessed);
    	} else {
    		callWrong(guessed);
    	}
    }
    
    private void printWin() {
    	println("You guessed the word: " + word);
    	println("You Win!");
    }
    
    /* called if user guesses is right */
    private void callRight(String guess) {
    	if(!charIncluded(guess)) {
    		includeChar(guess);
    		if(!matchWord()) {
    			println("That guess is correct");
    		}
    	}
    }
    
    /* called in wrong guess, reduces number of remained tries by one */
    private void callWrong(String guess) {
    	numGuesses -= 1;
    	println("There are no " + guess + "'s in the word");
    	canvas.noteIncorrectGuess();
    }
    
    /* called if user is out of all tries */
    private void CallLoser() {
    	println("You are completely hung");
    	println("The word was: " + word);
    	println("You lose.");
    }
    
    /* checks if user guess is right */
    private boolean charIncluded(String guess) {
    	return (dashWord.contains(guess));
    }
    
    /* replaces the dashes equivalent to right guess */
    private void includeChar(String guess) {
    	String newDashWord = "";
    	for (int i = 0; i < word.length(); i++) {
    		if (word.charAt(i) == guess.charAt(0)) {
    			newDashWord += guess;
    		} else {
    			newDashWord += dashWord.charAt(i);
    		}
    	}
    	dashWord = newDashWord;
    }
    
    /* check if user guessed the right word in full */
    private boolean matchWord() {
    	return dashWord == word;
    }
    
    /* gets the new guess word of the game turn */
    private String getNewWord() {
    	HangmanLexicon lexicon = new HangmanLexicon();
    	return lexicon.getWord(rgen.nextInt(lexicon.getWordCount())).toUpperCase();
    }
    
    /* build the equivalent dashes for the guess word */
    private String getDashWord(String word) {
    	String dashWord = "";
    	for (int i = 0; i < word.length(); i++) {
    		dashWord = dashWord + "-";
    	}
    	return dashWord;
    }
    
    private String word;
    private String dashWord;
    private int numGuesses;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanLexicon lexicon;
    private HangmanCanvas canvas;

}
