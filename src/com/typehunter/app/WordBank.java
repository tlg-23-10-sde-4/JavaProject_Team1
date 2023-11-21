package com.typehunter.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordBank {
    private static final List<String> words = loadWordsFromFile();

    public static String getRandomWord() {
      //  return words.get(new Random().nextInt(words.size()));
        if (words.isEmpty()) {
            // Handle the case when the list is empty
            return null;
        }
        // Get a random index
        int randomIndex = new Random().nextInt(words.size());

        // Return the selected word
        return words.remove(randomIndex);
    }


    public static ArrayList<String> getRandomWords(int amount) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < amount; ++i)
            result.add(getRandomWord());
        return result;
    }

    private static List<String> loadWordsFromFile() {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("resourceFiles/wordBank.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(words);
        return words;
    }

}