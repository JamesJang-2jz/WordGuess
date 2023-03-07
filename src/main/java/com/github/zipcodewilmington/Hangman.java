package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

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
    static String[] secretArray = secretWord.split("");
    int maxGuess;
    static int guessCount = 0;
    static String[] checker;
    static String holder = "";
    public Hangman() {
        maxGuess = 4;
    }
    public static void revealWord(String input) {
            for (int i = 0; i <= secretWord.length() - 1; i++) {
                if (input.equalsIgnoreCase(String.valueOf(secretArray[i]))) {
                    secretArray[i] = input;
                } else {
                    secretArray[i] = "-";
                }
            }
    }
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner scan = new Scanner(System.in);
        System.out.print("Word Game! Enter a letter: ");
        System.out.println(secretWord);
        do {
            String guess = scan.nextLine();
            revealWord(guess);
//            System.out.println(Arrays.toString(checker));
            System.out.println(Arrays.toString(secretArray));
        } while (!Arrays.equals(checker, secretArray));
//            if (guess == String.valueOf(secretArray[i])) {
//            String display = revealWord(guess);
            //System.out.println(secretArray); //this works for now
            guessCount++;
            // for loop to check each letter against guess
//            for (int i = 0; i < secretWord.length(); i++) {
//                if (guess.equals(Character.toString(secretWord.charAt(i)))) {
//                if arr[0] == guess, change display[0] to guess letter
//                }
//            }
            // array back into string. if string == secretword, end game
    }
        // sout game over or winner
////        System.out.println(secretArray);
//        System.out.println(secretWord);
    }

//            for (int i = 0; i <= secretWord.length() - 1; i++) {
//                System.out.print("-");
//            }
