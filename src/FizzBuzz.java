import java.util.Scanner;

public class FizzBuzz {
	Scanner input = new Scanner(System.in);
	public FizzBuzz() {
	}
	
	public void playGame() {
		boolean playing = true;
		int currentNumber = 1;
		String computerAnswer = "";
		String userAnswer = "";
		String correctUserAnswer = "";
		int score = 0;
		System.out.println("Let's play FizzBuzz!");
		System.out.println("Here are the rules to the game:");
		System.out.println("    1. Each player will say the next number in a sequence");
		System.out.println("    3. If the number is divisible by 5 the player will say \"Buzz\"");
		System.out.println("    4. If the number is divisible by both 3 and 5 the player will say \"FizzBuzz\"");
		System.out.println("Simple right? I will go first!");
		System.out.println("--------------------------------------FizzBuzz--------------------------------------");
		while (playing) {
			computerAnswer = determineFizzBuzz(currentNumber);
			currentNumber += 1;
			System.out.printf("Computer Says: %s\n", computerAnswer);
			System.out.print("Your Turn....: ");
			userAnswer = input.nextLine();
			correctUserAnswer = determineFizzBuzz(currentNumber);
			currentNumber += 1;
			if (!userAnswer.toLowerCase().equals((correctUserAnswer).toLowerCase())) {
				playing = false;
				System.out.printf("Whoops! Sorry that was wrong! You said %s when you should have said %s!\n", userAnswer, correctUserAnswer);
				System.out.printf("You got %d correct in a row!\n", score);
			} else {
				score ++;
			}
		}
	}
	
	public String determineFizzBuzz(int number) {
		String answer = "";
		if (number % 3 == 0) {
			answer += "Fizz";
		}
		if (number % 5 == 0) {
			answer += "Buzz";
		}
		if (answer.length() == 0) {
			answer = String.valueOf(number);
		}
		
		return answer;
	}
}
