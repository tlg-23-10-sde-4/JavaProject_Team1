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
                return new ArrayList<Animal>(Arrays.asList(new Animal("Frog", 1), new Animal("Deer", 2), new Animal("Bear", 3)));

            case TUNDRA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("Oakd", 2), new Animal("DASD", 3), new Animal("Abtgh", 2)));

            case SAVANNA:
                return new ArrayList<Animal>(Arrays.asList(new Animal("asdasd",2), new Animal("hhhh", 2), new Animal("fgrgrg", 2)));

        }

        return null;
    }

}