package com.oasis.infobyte;

import java.util.*;

class Game{
	public int randomNum;
	public int guess;
	public int noOfGuesses = 0;
	
	public void setNoOfGuesses(int noOfGuesses) {
		this.noOfGuesses = noOfGuesses;
	}
	
	public int getNoOfGuesses() {
	      return noOfGuesses;
	}
	
	public boolean IsCorrectNumber(int randomNum, int guessNum) {
		noOfGuesses++;
	    
		if(guessNum == randomNum ) {
			System.out.println("\nCONGRATULATIONS! YOU GUESSED THE NUMBER, IT WAS "+guessNum+"."); 
			System.out.println("YOU TOOK TOTAL "+noOfGuesses+ " ATTEMPTS TO GUESS.");
		    return true;
		}
		else if( guessNum < randomNum) {
			System.out.println("GUESS HIGHER NUMBER PLEASE!");
		}
		else if(guessNum > randomNum) {
			System.out.println("GUESS LOWER NUMBER PLEASE!");
		}
		return false;
	}
	 
}

public class NumberGuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.println("<--- WELCOME TO THE NUMBER GUESSING GAME! --->\n");
		Random rand = new Random();
        int randomNum = rand.nextInt(1,100);

        System.out.println("RULES OF THIS GAME");
        System.out.println("------------------");
        System.out.println("I GENERATED A NUMBER BETWEEEN 1 TO 100.");
        System.out.println("YOUR TASK IS GUESS THE NUMBER AT MINIMAL ATTEMPTS...\n");
        
		Game game = new Game();
		
		boolean flag = false;
	    while(!flag) {
	    	System.out.print("GUESS THE NUMBER : ");
			int guessNum = sc.nextInt();
			
            flag = game.IsCorrectNumber(randomNum, guessNum);
	    } 
		
		if(sc!=null) {
			sc.close();
		}
	}  
}
