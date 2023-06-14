package com.oasis.infobyte;

import java.util.*;

class Game{
	
	private int noGuesses = 0;
	
	public void setNoGuesses(int noGuesses) {
		this.noGuesses = noGuesses;
	}
	
	public int getNoGuesses() {
	      return noGuesses;
	}
	
	public boolean isCorrectNumber(int randNo, int guessNo) {
		noGuesses++;
	    
		if(guessNo<1 || guessNo>100) {
			System.out.println("Wrong Guess! Your guessing number should be within 1 to 100.");
		}
		else if(guessNo == randNo ) {
			System.out.println("...............................................................");
			System.out.println("\nCongratulations! You guessed the number successfully, it was "+guessNo+"."); 
			System.out.println("Your Score is : "+noGuesses);
		    return true;
		}
		else if( guessNo < randNo) {
			System.out.println("Guess Higher Number Please!");
		}
		else if(guessNo > randNo) {
			System.out.println("Guess Lower Number Please!");
		}
		return false;
	}
	 
}

public class NumberGuessingGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("           Welcome to the Number Guessing Game!     \n");
		Random rand = new Random();
        int randNo = rand.nextInt(1,100);

        System.out.println("Rules for this game:");
        System.out.println("===================");
        System.out.println("We generated a number between 1 to 100.");
        System.out.println("Now your task is to guess that number at minimum attempts.\n");
        
		Game game = new Game();
		
		boolean flag = false;
	    while(!flag) {
	    	System.out.print("Guess the number : ");
			int guessNo = sc.nextInt();
			
            flag = game.isCorrectNumber(randNo, guessNo);
	    } 
		
		sc.close();
	}
    
}
