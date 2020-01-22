package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        for (int guesses = 0; guesses < 5; guesses++) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Guess a number 1-10: ");

            String guess = userInput.nextLine();
            int userGuess = Integer.parseInt(guess);

            int randomNum = (int) (Math.random() * 10);

            if (userGuess == randomNum) {
                System.out.println("Correct!");
                break;
            } else {
                System.out.println("Nope.");
            }
        }
        System.out.println("Game over.");
    }
}