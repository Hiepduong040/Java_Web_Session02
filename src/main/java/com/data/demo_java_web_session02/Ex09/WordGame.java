package com.data.demo_java_web_session02.Ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGame {
    private static final String[] WORDS = {
            "COMPUTER", "PROGRAMMING", "JAVA", "SERVLET", "DATABASE",
            "ALGORITHM", "INTERNET", "NETWORK", "SOFTWARE", "DEVELOPER",
            "VIETNAM", "HANOI", "HOCHIMINH", "DANANG", "HALONG"
    };

    private static final int MAX_TRIES = 6;

    private String secretWord;
    private char[] guessedLetters;
    private List<Character> incorrectGuesses;
    private int triesLeft;
    private boolean gameWon;
    private boolean gameOver;

    public WordGame() {
        startNewGame();
    }

    public void startNewGame() {
        // Chon tu ngau nhien
        secretWord = getRandomWord();

        // Khoi tao mang chua cac chu cai da doan
        guessedLetters = new char[secretWord.length()];
        Arrays.fill(guessedLetters, '_');

        // Khoi tao danh sach cac chu cai doan sai
        incorrectGuesses = new ArrayList<>();

        // Dat lai so luot doan
        triesLeft = MAX_TRIES;

        // Dat lai trang thai tro choi
        gameWon = false;
        gameOver = false;
    }

    public void guessWord(String guess) {
        if (gameOver) {
            return;
        }

        // Chuyen chuoi doan thanh chu hoa
        guess = guess.toUpperCase();

        // Neu doan dung ca tu
        if (guess.equals(secretWord)) {
            // Dien tat ca chu cai
            for (int i = 0; i < secretWord.length(); i++) {
                guessedLetters[i] = secretWord.charAt(i);
            }
            gameWon = true;
            gameOver = true;
            return;
        }

        // Neu doan sai
        triesLeft--;

        // Kiem tra neu het luot doan
        if (triesLeft <= 0) {
            gameOver = true;
        }
    }

    public void guessLetter(char letter) {
        if (gameOver) {
            return;
        }

        // Chuyen chu cai thanh chu hoa
        letter = Character.toUpperCase(letter);

        // Kiem tra xem chu cai da doan chua
        if (containsLetter(incorrectGuesses, letter) || containsLetter(guessedLetters, letter)) {
            return;
        }

        boolean found = false;

        // Kiem tra xem chu cai co trong tu bi mat khong
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedLetters[i] = letter;
                found = true;
            }
        }

        // Neu khong tim thay chu cai
        if (!found) {
            incorrectGuesses.add(letter);
            triesLeft--;
        }

        // Kiem tra chien thang
        if (!String.valueOf(guessedLetters).contains("_")) {
            gameWon = true;
            gameOver = true;
        }

        // Kiem tra thua
        if (triesLeft <= 0) {
            gameOver = true;
        }
    }

    private boolean containsLetter(char[] array, char letter) {
        for (char c : array) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLetter(List<Character> list, char letter) {
        return list.contains(letter);
    }

    private String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    // Getters
    public String getSecretWord() {
        return secretWord;
    }

    public char[] getGuessedLetters() {
        return guessedLetters;
    }

    public String getGuessedLettersDisplay() {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < guessedLetters.length; i++) {
            display.append(guessedLetters[i]);
            if (i < guessedLetters.length - 1) {
                display.append(" ");
            }
        }
        return display.toString();
    }

    public List<Character> getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public String getIncorrectGuessesDisplay() {
        StringBuilder display = new StringBuilder();
        for (Character letter : incorrectGuesses) {
            display.append(letter).append(" ");
        }
        return display.toString();
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getMaxTries() {
        return MAX_TRIES;
    }

    public int getHangmanState() {
        return MAX_TRIES - triesLeft;
    }
}
