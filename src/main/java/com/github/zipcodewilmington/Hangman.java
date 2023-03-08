package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Scanner;

// James Jang
/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    boolean gameOver = false;
    static String[] wordBank = {"badminton","boast", "toast", "prime", "paint",
            "expert", "array", "moose", "goose","integer","bloat","rubble","spring"};
    static String secretWord = wordBank[(int)(Math.random() * wordBank.length)];
    static char[] secretArray = secretWord.toCharArray();
    int zeroGuess;
    static int guessCount = 5;
    static char[] checker = new char[secretWord.length()];
    public Hangman() {
        zeroGuess = 0;
    }
    public static void revealWord(char input) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (input == (secretArray[i])) {
                    checker[i] = input;
                }
            }
    }
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner scan = new Scanner(System.in);
        System.out.print("Word Game! Enter a letter: ");
        System.out.println(secretWord);
        for (int i = 0; i < secretWord.length(); i++) {
            checker[i] = '-';
        }
        do {
            char input = scan.nextLine().charAt(0);
            revealWord(input);
            System.out.println(checker);
            System.out.println("You have " + (guessCount) + " guesses left.");
            if (guessCount == game.zeroGuess) {
                System.out.println("you lost!");
            }
            guessCount--;

        } while (!Arrays.equals(checker, secretArray));
    }
}