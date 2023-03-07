package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    boolean gameOver = false;
    static String[] wordBank = {"badminton","boast", "toast", "prime", "pain",
            "expert", "array", "moose", "goose","integer","bloat","rubble","spring"};
    static String secretWord = wordBank[(int)(Math.random() * wordBank.length)];
    static char[] secretArray = secretWord.toCharArray();
    int maxGuess;
    static int guessCount = 0;
    String display = "";
    public Hangman() {
        maxGuess = 4;
    }
    public static String revealWord(String input) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i <= secretWord.length()-1; i++) {
            if (input.equalsIgnoreCase(String.valueOf(secretArray[i]))) {
                string.append(input);
            } else {
                string.append("-");
            }
        }   return string.toString();
    }
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Scanner scan = new Scanner(System.in);
        System.out.print("Word Game! Enter a letter: ");
        System.out.println(secretWord);
        String guess = scan.nextLine();
        do {
            for (int i = 0; i <= secretWord.length() - 1; i++) {
                System.out.print("-");
            }
            String display = revealWord(guess);
            System.out.println(display);
            //System.out.println(secretArray); //this works for now
            guessCount++;
            // for loop to check each letter against guess
//            for (int i = 0; i < secretWord.length(); i++) {
//                if (guess.equals(Character.toString(secretWord.charAt(i)))) {
//
//                    //if arr[0] == guess, change display[0] to guess letter
//                }
//            }
            // array back into string. if string == secretword, end game
        } while (guessCount < game.maxGuess);

        // sout game over or winner
////        System.out.println(secretArray);
//        System.out.println(secretWord);
    }
}

