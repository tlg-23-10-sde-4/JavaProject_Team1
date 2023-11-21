package com.typehunter;

import com.apps.util.Console;
import com.typehunter.app.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Hunter player;
    private List<Animal> animalPool = new ArrayList<>();
    private Location currentLocation = Location.FOREST;
    private String currentWord;
    private int errors = 0;
    private long elapsedTime = 0L;

    public void run() {
        initVars();

        //  starts timer for Hunter. This will run for the duration of the method (entire game)
        player.startTimer();

        while (currentLocation != null) {

            if (animalPool.size() == 0) {
                currentLocation = getNextLocation();
                createAnimalPool();
                if (currentLocation == null)
                    break;
            }

            Animal a = animalPool.remove(0);

            while (a != null && a.words.size() > 0) {
                currentWord = a.words.get(0);
                Console.clear();

                displayAnimalAndWord(a);

                if (getInput()) {
                    a.words.remove(0);
                    if (a.words.size() == 0)
                        break;
                }
            }
        }
        player.endTimer();
        System.out.println("Thanks for playing! -- the end!");
    }

    public void displayAnimalAndWord(Animal displayAnimal) {
        System.out.println(displayAnimal.asciiArt);
        System.out.println("[" + displayAnimal.name + "]: Type: " + currentWord);
    }

    private boolean getInput() {
        Scanner s = new Scanner(System.in);
        if (s.nextLine().toLowerCase().equals(currentWord)) {
            //Console.clear();
            return true;

        } else {
            player.incrementErrors();
        }
        return false;
    }

    private Location getNextLocation() {
        Location result = null;
        switch (currentLocation) {
            case FOREST:
                result = Location.TUNDRA;
                System.out.println("You've now entered the Tundra!");
                break;

            case TUNDRA:
                result = Location.SAVANNA;
                System.out.println("You've now entered the Savanna!");
                break;
            default:
                return null;
        }

        return result;
    }

    private void createAnimalPool() {
        if (currentLocation != null)
            animalPool = Location.getAnimalsIn(currentLocation);
    }

    private void initVars() {
        player = new Hunter("Scott");
        createAnimalPool();
    }
}