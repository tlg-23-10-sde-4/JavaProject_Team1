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
                        new Animal("Deer", 1, location),
                        new Animal("Moose", 1,location)));

            case TUNDRA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Rabbit", 1, location),
                        new Animal("Wolf", 1, location),
                        new Animal("Bear", 1, location)));

            case SAVANNA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Zebra", 1, location),
                        new Animal("Elephant", 1, location),
                        new Animal("Rhino", 1, location)));
        }

        return null;
    }
}