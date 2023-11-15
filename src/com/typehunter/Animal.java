package com.typehunter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal<Word> {
    private String name;
    private String image;   // pulls from file/path
    private String sound;   // pulls from file/path
    private int size;
    private int[] wordCount;
    private List<String> words = new ArrayList<>();

    private Animal (String name, String image, String sound, int size) {
        this.name = name;
        this.image = image;
        this.sound = sound;
        this.size = size;
    }

    public static Animal createInstance(String name, String image, String sound, int size) {
        return new Animal(name, image, sound, size);
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getSound() {
        return sound;
    }

    public int getSize() {
        return size;
    }

    public int[] getWordCount() {
        // pull the wordsArray, randomize, pull corresponding array index based on given int from location
        // and then        remove.
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
        String[] wordsArray = new String[words.size()];
        wordsArray = words.toArray(wordsArray);

        return wordsArray;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", image='" + image + '\'' +", sound='" + sound + '\'' +
                ", size=" + size + ", wordCount=" + Arrays.toString(wordCount) + ", words=" + words + '}';
    }
}