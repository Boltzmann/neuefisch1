package com.neuefische.stefan;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public short wrongCounter = 0; // If 15, game over.
    public boolean done = false;
    public boolean gameOver = false;
    String solution;
    char[] guessedChars;

    public Hangman(String solution) {
        this.solution = solution;
        initCharArray();
    }

    public char getCharFromUser() {
        Scanner scanner = new Scanner(System.in);
        String mess = "Geben Sie einen Buchstaben ein und drücken Sie ENTER:";
        System.out.println(mess);
        char typedChar = scanner.nextLine().charAt(0);
        System.out.println("\n" + "Buchstabe: " + typedChar);
        return typedChar;
    }


    public boolean gotSolution(char[] guessedString) {
        boolean same = true;
        for (int i = 0; i < this.solution.length(); i++) {
            if (guessedString[i] != this.solution.charAt(i)) {
                same = false;
                i = this.solution.length();
            }
        }
        return same;
    }

    public boolean containsSolutionSingleInput(char userInput) {
        return this.solution.contains(Character.toString(userInput));
    }

    public void guess() {
        char guessedChar = getCharFromUser();
        if (containsSolutionSingleInput(guessedChar)) {
            insertCharsInGuessedChars(guessedChar);
            this.done = gotSolution(guessedChars);
        } else {
            wrongCounter++;
        }
        short maxTries = 15;
        if (wrongCounter >= maxTries) {
            gameOver = true;
        }
    }

    private void initCharArray() {
        guessedChars = new char[this.solution.length()];
        Arrays.fill(guessedChars, '+');
    }

    private void insertCharsInGuessedChars(char guess) {
        int index = solution.indexOf(guess);
        while (index >= 0) {
            guessedChars[index] = guess;
            index = solution.indexOf(guess, index + 1);
        }
    }
}
