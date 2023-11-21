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
    private Hunter player;
    private LeaderBoard ranking;
    private HunterScore finalScore;
    private String correctWord;
    private String nextCorrectWord;
    private Animal currentAnimal;
    private Location currentLocation = null;
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

    /*
     *SCOTT: Added this method to reduce profile creation stuff in start(). More smaller better functioning
     *   intention is to:  1. prompt for name/  2. If name is found pull Hunter from List<Hunter>
     * 3. if name is not found create a new instance of Hunter with userinput as Hunter(String name)
     *
     *
     */

    public void playerProfile() {
        System.out.println("Please enter your name!");
        String input = scanner.next().trim().toUpperCase();
        System.out.println("Are you a new player? Y|N");
        String newPlayer = scanner.next().trim().toUpperCase();
        if (newPlayer.matches("Y")) {
        player = new Hunter(input);

        } if (newPlayer.matches("N")) {
            // if not new player grab existing Hunter player from LeaderBoard
        }

    }
    public void start() {

//        if (!isNewPlayer.equals("N")) { // SCOTT: IF() for existing players  ELSE new player
//            System.out.println("Enter your name: ");
//            String name = scanner.next().trim().toUpperCase();
//
//
//            // enter level you wish to start
//
//        } else {
//            Hunter player = new Hunter(isNewPlayer); // creates new Hunter with name as input from isNewPlayer
//            System.out.println("Happy Hunting!");
//        }
//        currentLocation = Location.FOREST;   // Start at first level location FOREST
//        playRound();
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


        while (true) {
            // Creates animalList
            currentLocation = Location.getNextLevel(currentLocation);
            if (currentLocation == null) {
                break;
            }
            Location.initializeAnimal(currentLocation);
            currentAnimal = Location.nextAnimal();


            while (currentAnimal != null) {
                //grab new word
                String theCorrectWord = Location.nextWord();
                currentAnimal = Location.nextAnimal();

                while (currentAnimal != null && currentAnimal.isAlive()) {


                    //Prompt for typing word
                    System.out.print("[" + currentAnimal.getName() + "]: "  + "Type the word: " + theCorrectWord);
                    String userInput = scanner.nextLine().trim();
                    if (userInput.equals(theCorrectWord)) {
                        currentAnimal.hit();
                        System.out.println("Correct! You hit the target.");
                        theCorrectWord = Location.nextWord();
                    } else {
                        // Handle the case when the input is incorrect
                        System.out.println("Incorrect! Try again.");
                        // player.getScore().incrementErrors();
                    }
                }
            }
        }
    }

















//
//        while (validInput == false) {
//            String theCorrectWord = Location.nextWord();
//            // Display the word to the user
//            System.out.print("Type the word: " + theCorrectWord);
//            String userInput = scanner.nextLine().trim();
//
//            if (userInput.equals(theCorrectWord)) {
//                validInput = true;
//                // Assuming you want to do something with the animal here
//                Animal currentAnimal = Location.nextAnimal();
//                currentAnimal.hit();
//                System.out.println("Correct! You hit the target.");
//
//                // Reset validInput for the next iteration
//                validInput = false;
//            } else {
//                // Handle the case when the input is incorrect
//                System.out.println("Incorrect! Try again.");
//                // Increment errors or perform other actions if needed
//                // player.getScore().incrementErrors();
//            }
//        }
//    }


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



    public void playRound() {
////        Location.nextAnimal();
////        Location.nextWord();
//        //9 rounds, 3 per location
//        //SCOTT: Changed to if to try and fix errors in isComplete()
//        if (!Location.isComplete()) {
//            Location.nextAnimal();
//            Location.nextWord();
//        } else {
//           // currentLocation.getNextLevel(); //SCOTT: Calling next round if Location.isComplete() is true
//        }
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

