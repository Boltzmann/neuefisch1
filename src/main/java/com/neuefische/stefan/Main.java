package com.neuefische.stefan;

import com.neuefische.stefan.Hangman;

public class Main {
    /**
     * Bonus-Aufgabe
     *
     * Schaue dir den Java Scanner an.
     * Schreibe ein Hangman-Spiel.
     * Tipp: Speichere die aktuell erratenen Buchstaben in einem Char-Array.
     */

    public static void main(String[] args) {
        Hangman hangthing = new Hangman("Joa");
        while (!hangthing.gameOver) {
            if (hangthing.done) {
                System.out.println("Gewonnen! :D");
                hangthing.gameOver = true;
            } else {
                hangthing.guess();
                System.out.println(hangthing.statusGraphicAsText());
                if(hangthing.gameOver) {
                    System.out.println("Verloren. :/");
                }
            }
        }
    }
}
