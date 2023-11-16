package com.typehunter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Animal<Word> {
    private final String name;
    private final String image;   // pulls from file/path
    private final String sound;   // pulls from file/path
    private final int size;
    private String wordCount;
    //private final List<String> words = new ArrayList<>();
    private String[] wordsArray = new String[0];
    private final Scanner scanner = new Scanner(System.in);
    private Hit hit;
    //C:\StudentWork\MiniProject\animal_resources

    public void execute() {
        Hit hit = calculateHit();
    }

    private Animal(String name, String image, String sound, int size) {
        this.name = name;
        this.image = image;
        this.sound = sound;
        this.size = size;
    }

    public static Animal createInstance(String name, String image, String sound, int size) {
        return new Animal(name, image, sound, size);
    }

    // @TODO: Pull method from Location enum
    public String getName() {
        return name;
    }

    // @TODO: set a file path, create local path and provide file
    public String getImage() {
        return image;
    }

    // @TODO: set a file path, create local path and provide file
    public String getSound() {
        return sound;
    }

    // @TODO: Pull method from Location enum
    public int getSize() {
        return size;
    }

    public String getWordCount() {
        getWords();
        List<String> animalWords = List.of(new String[wordsArray.length]); // needs to be given from Location enum
        int index = 0;
        for (String word : wordsArray) {
            animalWords.set(index, word);
            index++;
        }
        for (String word : wordsArray) {
            System.out.println(word);
            int deleteIndex = wordsArray.length;
            if (deleteIndex >= 0 && deleteIndex < animalWords.size()) {
                animalWords.remove(deleteIndex);
            }
        }
        return wordCount;
    }

    public String[] getWords() {
        List<String> words = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] wordsArray = new String[0];
        Collections.shuffle(words);
        wordsArray = words.toArray(wordsArray);
        return wordsArray;
    }

    private String calculateHit() {
        int wordIndex = 0;
        int givenIndex = locationIndex;
        wordCount = wordsArray[wordIndex];
        boolean validInput = false;
        while (!validInput) {
            System.out.println(wordCount);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.matches(String.valueOf(wordCount))) {
                validInput = false;
                wordIndex++;
            }
            if (wordIndex >= givenIndex) {
                validInput = true;
            }
        }
        return wordCount;
    }
}