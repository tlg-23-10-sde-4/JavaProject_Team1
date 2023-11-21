package com.typehunter;

import com.typehunter.app.Location;

import com.typehunter.app.WordBank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Animal {

    public String asciiArt;
    public String name;
    public ArrayList<String> words;

    public Animal(String name, int amountOfWords, Location location) {
        this.name = name;
        this.words = WordBank.getRandomWords(amountOfWords);
        this.asciiArt = readAsciiArtFromFile(getFilePath(location));
    }

    private String getFilePath(Location location) {
        String locationName = location.name().toUpperCase();
        String fileName = name.toLowerCase() + ".txt";
        return "resourceFiles/" + locationName + "/" + fileName;
    }


    private String readAsciiArtFromFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // Return an empty string if there's an error reading the file
        }
    }
}

