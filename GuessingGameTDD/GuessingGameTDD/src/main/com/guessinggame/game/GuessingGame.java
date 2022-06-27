package com.guessinggame.game;

import java.util.Random;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(10) + 1;
    private int countGuesses = 0;
    public String guess(int guessedNumber) {
        countGuesses++;
        String tryText = countGuesses == 1 ? "try" : "tries";
        String winningMessage = String.format("You got it in %d %s", countGuesses, tryText);
        String response = null;
        //return guessedNumber == getRandomNumber() ? winningMessage : "You didn't get it";
        if (countGuesses == 4 && guessedNumber != getRandomNumber()){
            response = String.format("You didn't get it and you've had %d %s. Game Over.", countGuesses, tryText);
        } else if (countGuesses > 4){
            String tooHighLowText = null;
            if (guessedNumber < getRandomNumber()){
                tooHighLowText = "- you're too low";
            } else if (guessedNumber > getRandomNumber()){
                tooHighLowText = "- you're too high";
            } else{
                tooHighLowText = "";
            }
            String loseText = String.format("You didn't get it %s", tooHighLowText);
            response = guessedNumber == getRandomNumber() ? winningMessage : loseText;
        }
        return response;
    }
    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        do {
            String input = System.console().readLine("Enter a number: ");
            if ("q".equals(input)){
                return;
            }
            String output = game.guess(Integer.parseInt(input));
            if (output.contains("You got it") || output.contains("over")){
                loopShouldContinue = false;
            }
        } while(loopShouldContinue);

    }
}
