package com.typehunter.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.typehunter.Animal;
import com.typehunter.Hunter;
import com.typehunter.HunterScore;
import com.typehunter.LeaderBoard;

import javax.swing.*;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
//TODO reference to a single prompted

public class Application {
    public static int location;
    public static Location currentLocation;
    private Animal animal;
    private int currentLevel;
    private Hunter player;
    private LeaderBoard ranking;
    private HunterScore finalScore;
    private String correctWord;
    private String nextCorrectWord;
    Scanner scanner = new Scanner(System.in);

    //fields -- don't hardcode; files.readString -- only displayed if user chooses; local variable
    //fields
    //put in a file. make local variable
    String rules = " How to play:\n" +
            "            - To be a master Type Hunter, the player must complete all three levels.\n" +
            "            - Each level contains 3 rounds with a progressing difficulty.\n" +
            "            - To successfully complete a round, the player must correctly type the words as they appear on the screen.\n" +
            "            - Each incorrectly typed attempts impacts the player's \"shooting\" accuracy.";

    //constructors


    //methods
    public void execute() {
            welcome();
            rule();
//            load();
            start();
            game();
//            save();
    }

    public void welcome() {
        System.out.println("=============================================");
        System.out.println();
        System.out.println("            T Y P E - H U N T E R            ");
        System.out.println();
        System.out.println("=============================================");
        //TO DO: insert hunter type image below
        ImageIcon typeHunter = new ImageIcon("images/hunter.png");
//        JOptionPane.showMessageDialog(null, "", "Welcome to Type Hunter", JOptionPane.INFORMATION_MESSAGE, typeHunter);
//        Console.clear();
        System.out.println(typeHunter);
        Console.clear();
    }

    public void rule() {
        System.out.println("=============================================");
        System.out.println("      R U L E S   O F   T H E   G A M E      ");
        System.out.println("=============================================");
        System.out.println(rules);
        Prompter begin = new Prompter(new Scanner(System.in));
        System.out.println("P=play, E=exit");
        String input = scanner.nextLine().trim();

        if (input.matches("P|p")) {
            System.out.println("L O A D I N G . . . .");
        } else {
            System.out.println("invalid entry 1");
            exit();
        }
    }

//    public void load() {
//        System.out.println("Enter your name: ");
//        String name = scanner.nextLine().trim().toUpperCase();
//        new Hunter(name);
//
////        Location location = Location.FOREST;
////        Location currentLocation = Location.getLocationByLevel(currentLevel);
//      new Animal(Animal.getName(), animal.getHitsRequired(), animal.getImageFile());
//    }

    public void start() {
        System.out.println("Are you a new player? Y|N");
        String isNewPlayer = scanner.next().trim().toUpperCase();


        if (!isNewPlayer.equals("N")) { // SCOTT: IF() for existing players  ELSE new player
            System.out.println("Enter your name: ");
            String name = scanner.next().trim().toUpperCase();

            // pull existing Hunter data
            // enter level you wish to start

        } else {
            Hunter player = new Hunter(isNewPlayer); // creates new Hunter with name as input from isNewPlayer
            System.out.println("Happy Hunting!");
        }
        currentLocation = Location.FOREST;   // Start at first level location FOREST
        playRound();
    }

    private int getUserInput(Scanner scanner, int min, int max) {
        int input = -1;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    validInput = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a number between " + min +
                        " and " + max + ".");
                scanner.next();
            }
        }
        return input;
    }

    public void game() {
        Location.initializeAnimal();
        String theCorrectWord = Location.nextWord();
        //System.out.println("Type the word: " + theCorrectWord);  // Display the word to the user
        System.out.println("ABOVE IF ");
        boolean validInput = false;

        while (!validInput) {
            //player.getScore().incrementErrors();
            System.out.print("Type the word: " + theCorrectWord);
            String userInput = scanner.nextLine().trim();

        if (userInput.matches(theCorrectWord)) {
            validInput = true;
           // animal.hit();
            System.out.println("IN IF");
            System.out.println("Correct! You hit the target.");
          Location.nextWord();

          validInput = false;



        }
        }



//        while (!userInput.equals(theCorrectWord)) {
//
//            if (userInput.equalsIgnoreCase(theCorrectWord)) {
//                System.out.println("IN IF");
//                System.out.println("Correct! You hit the target.");
//                animal.hit();
//                Location.nextWord();
//            } else {
//                System.out.println("IN ELSE");
//                System.out.println("\nIncorrect! Try again.");
//                System.out.print("Type the word: " + theCorrectWord);
//                 userInput = scanner.nextLine().trim();
//                //player.getScore().incrementErrors();
//            }

    }

    public void playRound() {
//        Location.nextAnimal();
//        Location.nextWord();
        //9 rounds, 3 per location
        //SCOTT: Changed to if to try and fix errors in isComplete()
        if (!Location.isComplete()) {
            Location.nextAnimal();
            Location.nextWord();
        } else {
            currentLocation.getNextLevel(); //SCOTT: Calling next round if Location.isComplete() is true
        }
    }


    public void save() {
        //call on the method from Hunterscore
        ranking.addScore(player.getName(), player.getScore());
        ranking.save();
        ranking.show();
    }

    private boolean playAgain() {
        System.out.print("Do you want to play again? (Y/N): ");
        String input = scanner.next().trim().toUpperCase();
        return input.equals("Y");
    }

    private void exit() {
        System.out.println("Exiting Type-Hunter. Good-Bye!!");
        scanner.close();
        System.exit(0);
    }
}

