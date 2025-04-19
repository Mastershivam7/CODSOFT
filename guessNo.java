import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int LOWER = 1;
        final int UPPER = 100;
        final int MAX_ATTEMPTS = 10;
        int score = 0;
        int round = 1;

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(UPPER - LOWER + 1) + LOWER;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess the number between " + LOWER + " and " + UPPER);
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            } else {
                round++;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("You won " + score + " round(s).");

        scanner.close();
    }
}
