package com.typehunter.app;

import com.typehunter.Animal;

import java.util.ArrayList;
import java.util.Arrays;

public enum Location {

    FOREST,
    TUNDRA,
    SAVANNA;


    public static ArrayList<Animal> getAnimalsIn(Location location) {
        switch(location) {

            case FOREST:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Frog", 1), new Animal("Deer", 2), new Animal("Moose", 3)));

            case TUNDRA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Rabbit", 3), new Animal("Wolf", 4), new Animal("Bear", 8)));

            case SAVANNA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Zebra",4), new Animal("Elephant", 8), new Animal("Rhinoceros", 12)));

        }

        return null;
    }

}