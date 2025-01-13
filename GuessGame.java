import java.util.Scanner;
import java.util.Random;

class Guess{
    static int generateNumber(int range){
      Random r1 =new Random();
      return (r1.nextInt(range)+1);
    } 
}

class NumberCheck {
    static boolean checkGuess(int guessedNumber, int userGuess) {
        if (userGuess == guessedNumber) {
            System.out.println("You guessed the correct number!");
            return true;
        } else if (userGuess > guessedNumber) {
            System.out.println("Your guess is too high.");
        } else {
            System.out.println("Your guess is too low.");
        }
        return false;
    }
}

class GuessGame {
    private static final int MAX_CHANCES = 11;

     static void startGame(int guessedNumber) {
        Scanner sc = new Scanner(System.in);
        int chancesLeft = MAX_CHANCES;
        while (chancesLeft > 0) {
            System.out.println("Enter your guess:");
            int userGuess = sc.nextInt();

            if (NumberCheck.checkGuess(guessedNumber, userGuess)) {
                System.out.println("Congratulations! You won!");
                return;
            }
            chancesLeft--;
            System.out.println("Chances left: " + chancesLeft);
            System.out.println();
        }
        System.out.println("Game Over! The correct number was: " + guessedNumber);
        System.out.println("Better luck next time.");
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int range = 0;
        boolean validInput = false;
        while (!validInput) {
          System.out.println("Enter the highest number (must be greater than 10):");
            try {
                range = Integer.parseInt(sc.nextLine());
                if (range <= 10) {
                    throw new IllegalArgumentException("The number must be greater than 10.");
                }
                validInput = true;
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } 
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int guessedNumber = Guess.generateNumber(range);
        System.out.println("\nGame Started! Try to guess the number.\n");
        startGame(guessedNumber);
    }
}