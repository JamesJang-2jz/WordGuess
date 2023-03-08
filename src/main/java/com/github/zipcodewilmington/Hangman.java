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
    static boolean gameOn = true;
    static String yesNo = "";
    static String[] wordBank = {"badminton","boast", "toast", "prime", "paint",
            "expert", "array", "moose", "goose","integer","bloat","rubble","spring"};
    static String secretWord = wordBank[(int)(Math.random() * wordBank.length)];
    static char[] secretArray = secretWord.toCharArray();
    int zeroGuess;
    static int guessCount = secretWord.length() + 3;
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
    public static boolean yesNo(String input) {
        if (Objects.equals(input, "yes")) {
            gameOn = true;
        } else if (Objects.equals(input, "no")) {
            gameOn = false;
        } return gameOn;
    }
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner scan = new Scanner(System.in);
        System.out.print("Word Game! Enter a letter: ");
        System.out.println(secretWord);
        for (int i = 0; i < secretWord.length(); i++) {
            checker[i] = '-';
        }
//        while (true) {
            do {
                char input = scan.nextLine().charAt(0);
                revealWord(input);
                guessCount--;
                System.out.println(checker);
                System.out.println("You have " + (guessCount) + " guesses left.");
                if (guessCount == game.zeroGuess) {
                    System.out.println("You lost!");
                    System.out.println("Play Again? yes or no");
                    String play = scan.nextLine();
                    yesNo(play);
                } else if (checker == secretArray) {
                    System.out.println("You Win! the secret word is " + secretWord);
                    System.out.println("Play Again? yes or no");
                    String play = scan.nextLine();
                    yesNo(play);
                }
            } while (gameOn);
//            (!Arrays.equals(checker, secretArray));
//            System.out.println("Play Again? yes or no");
//            String play = scan.nextLine();
//            yesNo(play);
//            }
    }
}