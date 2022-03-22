package com.neuefische.stefan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class HangmanTest {
    private InputStream sysInBackup;
    private ByteArrayInputStream in;

    private void configureInput(String charArray) {
        // see https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
        sysInBackup = System.in; // backup System.in to restore it later
        in = new ByteArrayInputStream(charArray.getBytes());
        System.setIn(in);
    }

    private void resetInputConfiguration() {
        // Reset System.in to its original
        // from https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
        System.setIn(sysInBackup);
    }

    @Test
    public void testGetCharFromUser() {
        configureInput("A");
        // Test simple user input.
        Hangman hanger = new Hangman("A");
        char userInput = hanger.getCharFromUser();
        Assertions.assertEquals('A', userInput);
        resetInputConfiguration();
    }

    @Test
    public void testSolutionContainsOneCharFromUser() {
        configureInput("AB");
        Hangman hanger = new Hangman("AB");
        char userInput = hanger.getCharFromUser();
        boolean tmp_res = hanger.containsSolutionSingleInput(userInput);
        Assertions.assertTrue(tmp_res);
        resetInputConfiguration();
    }

    @Test
    public void testSolutionContainsNotCharFromUser() {
        configureInput("AB");
        Hangman hanger = new Hangman("BB");
        char userInput = hanger.getCharFromUser();
        boolean tmp_res = hanger.containsSolutionSingleInput(userInput);
        Assertions.assertFalse(tmp_res);
        resetInputConfiguration();
    }

    @Test
    public void testisSolutionFound_compareCharArray2SolutionString() {
        Hangman hanger = new Hangman("Joachim");
        "Joachim".getChars(0, 7, hanger.guessedChars, 0);
        Assertions.assertTrue(hanger.gotSolution(hanger.guessedChars));
    }

    @Test
    public void testHangingPerson() {
        Hangman hanger= new Hangman("Someone");
        hanger.wrongCounter = 1;
        Assertions.assertEquals("|..............", hanger.statusGraphicAsText());
        hanger.wrongCounter = 15;
        Assertions.assertEquals("|||||||||||||||", hanger.statusGraphicAsText());
    }

}