package com.typehunter.app;

import com.typehunter.Animal;

import java.util.ArrayList;
import java.util.Arrays;

public enum Location {

    FOREST,
    TUNDRA,
    SAVANNA;


    public static ArrayList<Animal> getAnimalsIn(Location location) {
        switch (location) {

            case FOREST:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Frog", 1, location),
                        new Animal("Deer", 2, location),
                        new Animal("Moose", 3,location)));

            case TUNDRA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Rabbit", 3, location),
                        new Animal("Wolf", 4, location),
                        new Animal("Bear", 8, location)));

            case SAVANNA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Zebra", 4, location),
                        new Animal("Elephant", 8, location),
                        new Animal("Rhinoceros", 12, location)));
        }

        return null;
    }
}