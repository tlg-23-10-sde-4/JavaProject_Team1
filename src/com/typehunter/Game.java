package com.typehunter;
import com.typehunter.app.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Hunter player;
    private ArrayList<Animal> animalPool = new ArrayList<>();
    private Location currentLocation = Location.FOREST;
    private String currentWord;

    public void run() {
        initVars();

        while(currentLocation != null) {

            if (animalPool.size() == 0) {
                currentLocation = getNextLocation();
                createAnimalPool();
                if (currentLocation == null)
                    break;
            }

            Animal a = animalPool.remove(0);

            while(a != null && a.words.size() > 0) {
                currentWord = a.words.get(0);
                if (getInput(a.name)) {
                    a.words.remove(0);
                    if (a.words.size() == 0)
                        break;
                }
            }

        }

        System.out.println("Thanks for playing! -- the end!");
    }

    private boolean getInput(String animalName) {
        System.out.println("[" + animalName + "]: Type in: " + currentWord);
        Scanner s = new Scanner(System.in);
        if (s.nextLine().toLowerCase().equals(currentWord))
            return true;

        // todo: player. errors ++;


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
