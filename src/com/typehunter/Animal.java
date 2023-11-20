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
    private static String name;
    private static int hitsRequired;
    private String image;
    private String imageFile;
    private int hitsTaken = 0;
    private boolean isDead;
    private static String animalConstructor ="animalConstructor.txt";
    private final Scanner scanner = new Scanner(System.in);
    //TODO method hit, hit field starts at 0, ++

    public Animal(String name, int hitsRequired) {
        this.name = name;
        this.hitsRequired = hitsRequired;
    }

    public Animal(String name, int hitsRequired, String imageFile) {
        this.name = name;
        this.hitsRequired = hitsRequired;
        try {
            this.image = Files.readString(Path.of("resources/animals/images/" +
                    getName().toLowerCase() + ".txt"));  // duck.txt
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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

    public String show() {
        System.out.println(image);
        return image;
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

    public static String getName() {
        return name;
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
}