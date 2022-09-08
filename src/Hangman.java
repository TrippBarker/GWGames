import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
	
	private Scanner input = new Scanner(System.in);
	private ArrayList<Character> splitWord = new ArrayList<Character>();
	private ArrayList<Character> solvedWord = new ArrayList<Character>();
	private String userWord;
	private char userGuess = ' ';
	private int incorrectGuesses = -1;
	private boolean playing = true;
	
	public Hangman() {
	}
	
	public void playGame() {
		System.out.println("Welcome to hangman!");
		while (playing) {
			System.out.println("Enter a word for your friend to guess!");
			System.out.print(">");
			userWord = input.nextLine().toLowerCase();
			System.out.println();
			System.out.print("\033[H\033[2J");
	        System.out.flush();
	        for (int i = 0; i < userWord.length(); i++) {
	        	splitWord.add(userWord.charAt(i));
	        	solvedWord.add('_');
	        }
	        while (incorrectGuesses < 6 && playing) {
	        	System.out.println(drawBoard(checkGuess()));
	        	if (solvedWord.contains('_')) {
	        		System.out.printf("Enter your guess: ");
		        	userGuess = input.nextLine().charAt(0);
	        	} else {
	        		System.out.println("You guessed the word!");
	        		playing = false;
	        	}
	        	
	        }
	        
		}
	}
	
	public String checkGuess() {
		boolean goodGuess = false;
		String solvedWordStr = "";
		for (int i = 0; i < userWord.length(); i++) {
			if (splitWord.get(i) == userGuess) {
				solvedWord.set(i, userGuess);
				goodGuess = true;
			}
		}
		if (!goodGuess) {
			incorrectGuesses++;
		}
		for (char letter : solvedWord) {
			solvedWordStr += letter;
		}
		return solvedWordStr;
	}
	
	public String drawBoard(String line7) {
		String line1 = " ______\n";
		String line2 = "|      |\n";
		String line3 = "|       \n";
		String line4 = "|       \n";
		String line5 = "|       \n";
		String line6 = "|=========\n";
		if (incorrectGuesses > 0) {
			line3 = "|      O\n";
		}
		if (incorrectGuesses > 1) {
			line4 = "|      |\n";
		}
		if (incorrectGuesses > 2) {
			line4 = "|     /|\n";
		}
		if (incorrectGuesses > 3) {
			line4 = "|     /|\\\n";
		}
		if (incorrectGuesses > 4) {
			line5 = "|     /\n";
		}
		if (incorrectGuesses > 5) {
			line5 = "|     / \\\n";
		}
		return line1 + line2 + line3 + line4 + line5 + line6 + line7;
	}
	
	
}
