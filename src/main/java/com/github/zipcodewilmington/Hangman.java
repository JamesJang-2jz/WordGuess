package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

// James Jang
/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    static boolean playAgain = true;
    static boolean gameOver = true;
    static String[] wordBank = {"badminton", "boast", "toast", "prime", "paint",
            "expert", "array", "moose", "goose", "integer", "bloat", "rubble", "spring"};
    static String secretWord;
    static char[] secretArray;
    int zeroGuess;
    static int guessCount;
    static char[] checker;
    static Scanner scan = new Scanner(System.in);
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
    public String getSecretWord() {
        String result = wordBank[(int) (Math.random() * wordBank.length)];
        secretArray = result.toCharArray();
        guessCount = result.length() + 3;
        checker = new char[result.length()];
        return result;
    }
    public static void yesNo(String input) {
        if (Objects.equals(input.toLowerCase(), "yes")) {
            playAgain = true;
            gameOver = true;
        } else if (Objects.equals(input.toLowerCase(), "no")) {
            playAgain = false;
        }
    }
    public static void gameOver(){
        gameOver = false;
    }
    public static void main(String[] args) {
        Hangman game = new Hangman();
        while (playAgain) {
            System.out.print("Word Game! Enter a letter: ");
            secretWord = game.getSecretWord();
            for (int i = 0; i < secretWord.length(); i++) {
                checker[i] = '-';
            }
            do {
                char input = scan.nextLine().charAt(0);
                revealWord(input);
                guessCount--;
                System.out.println(checker);
                System.out.println("You have " + (guessCount) + " guesses left.");
                if (guessCount == game.zeroGuess) {
                    gameOver();
                } else if (Arrays.equals(checker, secretArray)){
                    gameOver();
                }
            } while (gameOver);
            if (guessCount == game.zeroGuess) {
                System.out.println("You lost!");
                System.out.println("Play Again? yes or no");
                String play = scan.nextLine();
                yesNo(play);
            } else if (Arrays.equals(checker, secretArray)) {
                System.out.println("You Win! the secret word is " + secretWord);
                System.out.println("Play Again? yes or no");
                String play = scan.nextLine();
                yesNo(play);
            }
        }
        }

}
