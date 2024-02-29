import java.util.Scanner;
import java.util.Random;

class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int virtualNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfTries = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("Number Guessing Game!");
            System.out.println("You have 15 attempts to guess the number between " + lowerBound + " and " + upperBound + ".");
            while (numberOfTries < 15 && !hasGuessedCorrectly) {
                System.out.println("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;
		if (guess > upperBound) {
			System.out.println("please guess the no between 1 to 100");
		}
                if (guess ==  virtualNumber) {
                    System.out.println("Congratulations! You guessed the number in " + numberOfTries + " attempts.");
                    hasGuessedCorrectly = true;
                    score++;
                } else if (guess < virtualNumber) {
                    System.out.println("Your guess number is low.");
                } else {
                    System.out.println("Your guess number is high.");
                }
            }
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you have crossed the limits of your attempts. The number was " + virtualNumber + ".");
            }
            System.out.println("Your score is " + score + ".");
            System.out.print("Do you want to play again? (y/n): ");
            String playAgainInput = scanner.next();
            if (playAgainInput.equalsIgnoreCase("n")) {
                playAgain = false;
            }
        }
        System.out.println("Thank you for playing!");
    }
}

