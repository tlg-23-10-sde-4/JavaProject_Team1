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
    private String[] wordCount;
    private final List<String> words = new ArrayList<>();
    private String[] wordsArray = new String[0];
    private final Scanner scanner = new Scanner(System.in);
    private Hit hit;
    //C:\StudentWork\MiniProject\animal_resources

    public void execute() {
        Hit hit = calculateHit();
    }

    public Animal(String name, String image, String sound, int size, String[] wordCount) {
        this.name = name;
        this.image = image;
        this.sound = sound;
        this.size = size;
        this.wordCount = wordCount;
    }

    public static Animal createInstance(String name, String image, String sound, int size, String[] wordCount) {
        return new Animal(name, image, sound, size, wordCount);
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

    public String[] getWordCount() {
        getWords();
        List<String> animalWords = List.of(new String[words.size()]); // needs to be given from Location enum
        int index = 0;
        for (String word : wordsArray) {
            animalWords.set(index, word);
            index++;
        }
        for (String word : wordsArray) {
            System.out.println(word);
            int deleteIndex = words.size();
            if (deleteIndex >= 0 && deleteIndex < animalWords.size()) {
                animalWords.remove(deleteIndex);
            }
        }
        return animalWords.toArray(new String[0]);
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
        String[] wordsArray = new String[words.size()];
        Collections.shuffle(words);
        wordsArray = words.toArray(wordsArray);
        return wordsArray;
    }

    private Hit calculateHit() {
        Hit hit = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.println(words);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.matches(String.valueOf(words))) {
                validInput = true;
                hit = null;
            }
        }
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", image='" + image + '\'' +", sound='" + sound + '\'' +
                ", size=" + size + ", wordCount=" + Arrays.toString(wordCount) + ", words=" + words + '}';
    }

    private class Hit {
    }
}