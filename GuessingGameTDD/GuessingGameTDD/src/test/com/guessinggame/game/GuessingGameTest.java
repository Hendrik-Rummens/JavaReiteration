package com.guessinggame.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp(){
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinningSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals(null, message);
    }

    @Test
    public void testOneWrongNegGuessSituation(){
        String message = game.guess(-5);
        assertEquals(null, message);
    }

    @Test
    public void testTwoWrongPosGuessSituation(){
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);
        assertEquals(null, message);
    }


    //@RepeatedTest(10)
    @Test
    public void testRandomNumberGeneration(){
        // 1 2 3 4 5 6 7 8 9 10
        int[] randomNumCount = new int[11];
        for (int counter=0; counter < 100; counter++){
            GuessingGame localGame = new GuessingGame();
            int randomNum = localGame.getRandomNumber();
            randomNumCount[randomNum] = 1;
        }
        int sum = 0;
        for (int counter=0; counter<11; counter++){
            sum += randomNumCount[counter];
        }
        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuesses(){
        makeThreeWrongGuesses();
        String guess = game.guess(-4);
        assertEquals("You didn't get it and you've had 4 tries. Game Over.", guess);
    }

    private void makeThreeWrongGuesses() {
        game.guess(-1);
        game.guess(-2);
        game.guess(-3);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect(){
        game.guess(-1);
        game.guess(-2);
        game.guess(-3);
        int correctAnswer = game.getRandomNumber();
        String guess = game.guess(correctAnswer);
        //assertEquals("You didn't get it and you've had four tries. Game Over.", guess);
        assertEquals(null, guess);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect(){
        game.guess(-1);
        game.guess(-2);
        int correctAnswer = game.getRandomNumber();
        String guess = game.guess(correctAnswer);
        //assertEquals("You didn't get it and you've had four tries. Game Over.", guess);
        assertEquals(null, guess);
    }
}
