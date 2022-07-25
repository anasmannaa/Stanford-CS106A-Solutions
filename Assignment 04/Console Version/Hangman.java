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
	
	private static final int MAX_TEMPS = 8;

    public void run() {
		/* You fill this in */
    	
    	initGame();
    	printWelcome();
    	playTheGame();
    	
	}
    
    private void initGame() {
    	word = getNewWord();
    	dashWord = getDashWord(word);
    	numGuesses = MAX_TEMPS;
    }
    
    private void printWelcome() {
    	println("Welcome to Hangman!");
    }
    
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
    
    private void callRight(String guess) {
    	if(!charIncluded(guess)) {
    		includeChar(guess);
    		if(!matchWord()) {
    			println("That guess is correct");
    		}
    	}
    }
    
    private void callWrong(String guess) {
    	numGuesses -= 1;
    	println("There are no " + guess + "'s in the word");
    }
    
    private void CallLoser() {
    	println("You are completely hung");
    	println("The word was: " + word);
    	println("You lose.");
    }
    
    private boolean charIncluded(String guess) {
    	return (dashWord.contains(guess));
    }
    
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
    
    private boolean matchWord() {
    	return dashWord == word;
    }
    
    private String getNewWord() {
    	HangmanLexicon lexicon = new HangmanLexicon();
    	return lexicon.getWord(rgen.nextInt(lexicon.getWordCount())).toUpperCase();
    }
    
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

}
