package com.typehunter.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class dummy {
    package typing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

    public class Game {
        private static final int INITIAL_WORDS_PER_ROUND = 3;
        private static final int WORDS_PER_ROUND_INCREMENT = 2;
        private static final int MAX_WORDS_PER_ROUND = 10;
        private static final int TIME_LIMIT_SECONDS = 30;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<String> words = loadWordsFromFile(); // Specify your file path here

            if (words.isEmpty()) {
                System.out.println("Unable to load words from the file. Exiting...");
                return;
            }

            int totalScore = 0;
            int totalRetries = 0;
            int roundScore;
            int roundRetries;
            int wordsPerRound = INITIAL_WORDS_PER_ROUND;

            do {
                roundScore = 0;
                roundRetries = 0;

                for (int i = 0; i <wordsPerRound; i++) {
                    String targetWord = getRandomWord(words);
                    System.out.println("Your word: " + targetWord);

                    // Record the start time
                    long startTime = System.currentTimeMillis();

                    boolean wordGuessed = false;

                    while (true) {
                        // Get user input
                        System.out.print("Type here: ");
                        String userInput = scanner.next();

                        // Record the end time
                        long endTime = System.currentTimeMillis();

                        // Calculate the time taken in seconds
                        double timeTaken = (endTime - startTime) / 3000.0;

                        // Check if the word is correct and within the time limit
                        if (userInput.equals(targetWord) && timeTaken <= TIME_LIMIT_SECONDS) {
                            System.out.println("Correct! Time taken: " + timeTaken + " seconds");
                            roundScore++;
                            wordGuessed = true;
                            break;
                        } else if (timeTaken > TIME_LIMIT_SECONDS) {
                            System.out.println("Time's up! Game over for this round.");
                            break;
                        } else {
                            System.out.println("Incorrect! Try again.");
                            roundRetries++;
                        }
                    }

                    if (!wordGuessed) {
                        // Move to the next round if the word was not guessed
                        break;
                    }
                }

                totalScore += roundScore;
                totalRetries += roundRetries;

                System.out.println("End of round. Your score for this round: " + roundScore);
                System.out.println("Total score: " + totalScore);
                System.out.println("Total retries: " + totalRetries);

                if (roundScore >= wordsPerRound) {
                    // Advance to the next round
                    wordsPerRound += WORDS_PER_ROUND_INCREMENT;
                    if (wordsPerRound > MAX_WORDS_PER_ROUND) {
                        System.out.println("Congratulations! You've completed all rounds!");
                        break;
                    }
                } else {
                    System.out.println("You need to correctly type at least " + wordsPerRound + " words to advance to the next round.");
                    break;
                }

                System.out.println("Press 'q' to quit or any key to continue the next round: ");
            } while (!scanner.next().equalsIgnoreCase("q"));

            System.out.println("Game over. Your final score: " + totalScore);
            System.out.println("Total retries: " + totalRetries);

            scanner.close();
        }

        private static List<String> loadWordsFromFile() {
            List<String> words = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("text/wordBank.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    words.add(line.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return words;
        }

        private static String getRandomWord(List<String> words) {
            Random random = new Random();
            return words.get(random.nextInt(words.size()));
        }
    }
}