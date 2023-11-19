package com.typehunter;

import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Animal {
    private final String name;
    private static int hitsRequired;
    private String imageFile;
    private int hitsTaken = 0;
    private boolean isDead;
    private static String animalConstructor ="animalConstructor.txt";
    private final Scanner scanner = new Scanner(System.in);
    //TODO method hit, hit field starts at 0, ++

    private Animal(String name, int hitsRequired, String imageFile) {
        this.name = name;
        this.hitsRequired = hitsRequired;
        this.imageFile = imageFile;
    }

    public static List<Animal> createAnimalFromFile() {
        List<Animal> animals = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(animalConstructor));
            for (String line : lines) {
                String[] tokens = line.split(",");
                    String name = tokens[0].trim();
                    int size = Integer.parseInt(tokens[1]);
                    String imageFile = tokens[2];
                    Animal animal = new Animal(name, hitsRequired, imageFile);
                    animals.add(animal);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public boolean hit() {
        hitsTaken++;
        return (hitsTaken == hitsRequired);
    }

    public boolean isDead() {
        return (hitsTaken == hitsRequired);
    }

    public int getHitsRequired() {
        return hitsRequired;
    }

    public String getName() {
        return name;
    }

    // @TODO: set a file path, create local path and provide file
    // Reads image from text file
    public String displayImage() {
        try (BufferedReader reader = new BufferedReader(new FileReader(imageFile))) {

            while ((imageFile = reader.readLine()) != null) {
                return imageFile;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }

    // TODO: ADD actual file path
    // Reads .wav file for sound clip of animal.
    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch(UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    // After words have been pulled from text file. This will assign to animals
//    public String getWordCount() {
//        List<String> animalWords = List.of(new String[wordsArray.length]); // needs to be given from Location enum
//        int index = 0;
//        for (String word : wordsArray) {
//            animalWords.set(index, word);
//            index++;
//        }
//        for (String word : wordsArray) {
//            System.out.println(word);
//            int deleteIndex = wordsArray.length;
//            if (deleteIndex >= 0 && deleteIndex < animalWords.size()) {
//                animalWords.remove(deleteIndex);
//            }
//        }
//        return wordCount;
//    }

    // Reading from the file to get words
    // Files.readAllLines
//    public String[] getWordFile() {
//        List<String> words = new ArrayList<>();
//        try (BufferedReader in = new BufferedReader(new FileReader("animal_words/wordBank.txt"))) { // DONT USE THE STUPID READER
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String[] wordsArray = new String[0];
//        Collections.shuffle(words);
//        wordsArray = words.toArray(wordsArray);
//        return wordsArray;
//    }
    // This checks if the user input matches the word. Check Prompter class from Jay?
//    private String calculateHit() {
//        int wordIndex = 0;
//        int givenIndex = size;
//        wordCount = wordsArray[wordIndex];
//        boolean validInput = false;
//        while (!validInput) {
//            System.out.println(wordCount);
//            String input = scanner.nextLine().trim().toLowerCase();
//            if (input.matches(String.valueOf(wordCount))) {
//                validInput = false;
//                wordIndex++;
//            }
//            if (wordIndex >= givenIndex) {
//                validInput = true;
//            }
//        }
//        return wordCount;
//    }
}