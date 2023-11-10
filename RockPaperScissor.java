/*
* This program is the basic rock, paper, scissors program.
*
* @author  Jonathan Pasco-Arnone
* @version 0.5
* @since   2021-12-02
*/

import java.util.Random;
import java.util.Scanner;

/**
* This program is the basic rock, paper, scissors program.
*/
final class RockPaperScissor {

    /**
    * This constant contains the string "error".
    */
    public static final String ERROR_TEXT = "error";

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private RockPaperScissor() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * This program is the basic rock, paper, scissors program.
    *
    * @return result
    */
    static String rockPaperScissorGame() {
        // Variables/Constants.
        final int max = 3;
        final int min = 1;
        final String returnValue;
        final String computerChoice;
        final String rock = "rock";
        final String paper = "paper";
        final String scissors = "scissors";
        final String computerChoiceText = "The computer chose ";

        // Inputs.
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nPlease make your choice "
            + "(rock, paper, or scissors): ");
        final String choice = userInput.nextLine();

        // Generated choice
        final Random randNumberGeneration = new Random();
        final int randomNumber = randNumberGeneration.nextInt(
            (max - min) + 1) + min;

        if (randomNumber == 1) {
            computerChoice = rock;
        } else if (randomNumber == 2) {
            computerChoice = paper;
        } else {
            computerChoice = scissors;
        }

        if (choice.equals(computerChoice)) {

            System.out.println(computerChoiceText + computerChoice);
            System.out.println("You Tied. Chose again\n\n\n");
            returnValue = rockPaperScissorGame();

        } else if (choice.equals(paper) && computerChoice.equals(rock)
            || choice.equals(scissors) && computerChoice.equals(paper)
            || choice.equals(rock) && computerChoice.equals(scissors)) {

            System.out.println(computerChoiceText + computerChoice);
            returnValue = "win";

        } else if (!(choice.equals(rock) || choice.equals(paper)
            || choice.equals(scissors))) {
            returnValue = ERROR_TEXT;
        } else {
            System.out.println(computerChoiceText + computerChoice);
            returnValue = "lose";
        }
        return returnValue;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        System.out.println("This is the rock, paper, scissors game.");

        final String result = rockPaperScissorGame();

        if (result.equals(ERROR_TEXT)) {
            System.out.println("Invalid Input");
        } else {
            // Output.
            // Will either be "You win" or "You lose."
            System.out.println("You " + result);
        }
    }
}
