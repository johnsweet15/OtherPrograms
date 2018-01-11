package Hangman;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hangman {

	private static String[] word; // all letters are unhidden
	private static String[] wordHidden; // unknown letters are hidden while known ones are not
	private static int tries;
	private static ArrayList<String> guesses;
	
	//constructor
	public Hangman(String word){
		Hangman.word = word.split("");
		wordHidden = new String[Hangman.word.length];
		
		for(int i = 0; i < wordHidden.length; i++){
			if(Hangman.word[i].equals(" "))
				wordHidden[i] = " ";
			else
				wordHidden[i] = "_";
		}
		tries = 6;
		guesses = new ArrayList<String>();
	}
	
	// Creates a game with the word in blanks
	public static void createGame(){
		System.out.println("");
		System.out.println("");
		
		for(String str : wordHidden)
			System.out.print(str + " ");
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("--------");
		System.out.println("|       |");
		for(int i = 0; i < 4; i++){
			System.out.println("|");
		}
		System.out.println("--------");
	}
	
	// returns true if word contains a correct letter
	public static boolean containsLetter(String letter){
		for(String str : word){
			if(str.equalsIgnoreCase(letter))
				return true;
		}
		return false;
	}
	
	// returns true if wordHidden contains a correct letter
	public static boolean blankContainsLetter(String letter){
		for(String str : wordHidden){
			if(str.equalsIgnoreCase(letter))
				return true;
		}
		return false;
	}
	
	// adds the correct letter to wordHidden and replaces underscore
	public static void addLetter(String letter){
		for(int i = 0; i < word.length; i++){
			if(word[i].equalsIgnoreCase(letter)){
				if(Character.isUpperCase(word[i].charAt(0))) // matches case of guess to case of actual letter
					wordHidden[i] = letter.toUpperCase();
				else if(Character.isLowerCase(word[i].charAt(0))) // matches case of guess to case of actual letter
					wordHidden[i] = letter.toLowerCase();
				else
					wordHidden[i] = letter; // makes sure special characters show up since they don't have case
			}
		}
	}
	
	// Prints out current game with hidden and unhidden letters
		public static void getGame(){
			for(String str : wordHidden)
				System.out.print(str + " ");
			
			System.out.println("");
			System.out.println("");
			
			System.out.println("--------");
			System.out.println("|       |");
			
			if(tries == 0){
				System.out.println("|       o");
				System.out.println("|      -|-");
				System.out.println("|      / \\");
			}
			
			if(tries == 1){
				System.out.println("|       o");
				System.out.println("|      -|-");
				System.out.println("|      / ");
			}
			
			if(tries == 2){
				System.out.println("|       o");
				System.out.println("|      -|-");
				System.out.println("|");
			}
			
			if(tries == 3){
				System.out.println("|       o");
				System.out.println("|      -|");
				System.out.println("|");
			}
			
			if(tries == 4){
				System.out.println("|       o");
				System.out.println("|       |");
				System.out.println("|");
			}
			
			if(tries == 5){
				System.out.println("|       o");
				System.out.println("|");
				System.out.println("|");
			}
			if(tries == 6){
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
			}
			System.out.println("--------");
			System.out.println("");
			System.out.print("Wrong letters used : ");
			for(String str : guesses){
				System.out.print(str + " ");
			}
			System.out.println("");
		}
	
	public static void main(String[] args){
		
		try{
			System.out.println("Hangman Game");
			System.out.println("Enter your word or phrase:");
			
			Scanner scn = new Scanner(System.in);
			String word = scn.nextLine();
			
			@SuppressWarnings("unused")
			Hangman game = new Hangman(word);
			
			for(int i = 0; i < 10; i++){
				System.out.println("*DONT SCROLL UP*");
			}
			
			if(!(word.matches("[a-zA-Z ]*")))
				System.out.println("NOTE: The answer contains special characters or numbers");
			
			System.out.println("Number of wrong answers left: " + tries);
			
			createGame();
			
			while(true){
				String letter = scn.next();
				
				if(containsLetter(letter)) // if letter is correct it is added
					addLetter(letter);
				else{
					System.out.println("There are no " + letter + "'s"); // otherwise tries decreases by 1
					if(!(guesses.contains(letter)))
						guesses.add(letter);
					tries--;
				}
				
				// losing statement
				if(tries == 0){
					getGame();
					System.out.println("You lose!");
					break;
				}
				//winning statement
				if(!(blankContainsLetter("_")) && tries > 0){
					getGame();
					System.out.println("You win!");
					break;
				}
				
				System.out.println("Number of wrong answers left: " + tries);
				System.out.println("");
				getGame();
			}
			scn.close();
		}catch(InputMismatchException e){
			System.out.println("ERROR: A number was not entered");
		}	
	}
}
