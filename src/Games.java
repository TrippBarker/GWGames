import java.util.Scanner;
public class Games {
	public static FizzBuzz fizzBuzz = new FizzBuzz();
	
	public static void main(String[] args) {
		boolean playing = true;
		Scanner input = new Scanner(System.in);
		while (playing) {
			System.out.println("Please select a Game to play:");
			System.out.println("1. FizzBuzz");
			System.out.print(">");
			playGame(input.nextLine().toLowerCase());
			System.out.println("Play another game?");
			System.out.print(">");
			playing = playAgain(input.nextLine().toLowerCase());
		}

	}
	
	public static void playGame(String gameName) {
		switch (gameName) {
			case "fizzbuzz" :
				fizzBuzz.playGame();
				break;
		}
			
	}
	
	public static boolean playAgain(String again) {
		if (again.equals("yes") || again.equals("y")) {
			return true;
		} else {
			return false;
		}
	}

}
