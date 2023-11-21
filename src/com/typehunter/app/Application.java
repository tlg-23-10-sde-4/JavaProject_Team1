package com.typehunter.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.typehunter.*;

import javax.swing.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;


import java.util.Scanner;
//TODO reference to a single prompted

public class Application {
    private Hunter player;

    private LeaderBoard ranking;

    private String correctWord;
    private LeaderBoard board;
    private String nextCorrectWord;
    private Animal currentAnimal;
    private Location currentLocation = null;
    private LeaderBoard bigBoard;
    Scanner scanner = new Scanner(System.in);

    String rules ="resourceFiles/images/rules.txt";

    //methods
    public void execute() {
            welcome();
            rule();
            bigBoard = LeaderBoard.getInstance();
            playerProfile();
            // Creates Game for the purposing of calling run() in game
        Game game = new Game(bigBoard);
        game.run();

           save();
           show();
           exit();

    }

    public void welcome() {
        System.out.println("=============================================");
        System.out.println();
        System.out.println("            T Y P E - H U N T E R            ");
        System.out.println();
        System.out.println("=============================================");

        displayAsciiArtFromFile("resourceFiles/images/hunter.txt");
        Console.clear();
    }
    private void displayAsciiArtFromFile(String filePath) {
        try {
            Path asciiArtPath = Path.of(filePath);
            String asciiArt = Files.readString(asciiArtPath);
            System.out.println(asciiArt);
        } catch (IOException e) {
            System.out.println("Error reading ASCII art from file: " + e.getMessage());
        }
    }
    public void rule() {

        /// need to delete this banner
        System.out.println("=============================================");
        System.out.println("      R U L E S   O F   T H E   G A M E      ");
        System.out.println("=============================================");


        // displays rules
        displayAsciiArtFromFile(rules);


        //Prompter begin = new Prompter(new Scanner(System.in));
        System.out.println(rules);

        System.out.println("P = Play, E = Exit");
        String input = scanner.nextLine().trim();

        if (input.matches("p|P")) {
            System.out.println("L O A D I N G . . . .");

        } else if (input.matches("e|E")) {

            System.out.println("Exiting");
            exit();

        } else {
            System.out.println("Please choose P to Play! Or E to Exit :( ");
        }
    }


//SCOTT NOTE: i commented in here because i cant get to the result i want
    public void playerProfile() {

        String input;
        String newPlayer;

        while (true) {
            System.out.println("Please enter your name!");
            input = scanner.next().trim();

            // Validate name
            if (!input.isEmpty()) {
                break; // Exit the loop if a valid name is provided
            } else {
                System.out.println("Invalid name. Please enter your name.");
            }
        }
        System.out.println("Are you a new player? Y|N");
        newPlayer = scanner.next().trim();
        LeaderBoard bigBoard = LeaderBoard.getInstance();
        Hunter player = bigBoard.findPlayer(input);

        if (player != null) {
            // Player found, use the existing player profile
            System.out.println("Existing player profile loaded: " + player.getName());
        } else {
            // Player not found, create a new player profile
            player = new Hunter(input);
            bigBoard.addPlayer(player); // Add the new player to the leaderboard
            System.out.println("New player profile created: " + player.getName());
        }
    }

        System.out.println("Please enter your name!");
        String input = scanner.next().trim(); // Save the input name to use for name for Hunter()

        System.out.println("Are you a new player? Y|N");
        String newPlayer = scanner.next().trim();

        // if new player add the Hunter  to our List<Hunter> file
        if (newPlayer.matches("Y|y")) {
        player = new Hunter(input); // i think this might come back has name being Y but its input from top scanner idk

        } else if (newPlayer.matches("N|n")) {

            /*
             *Match input name to names in List<Hunter>
             */
            //
        } else {
            System.out.println("Please enter Y for New Player or N for Existing Player");
        }





    //is this method necessary?
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


    public void save() {

        bigBoard.save();
    }

    public void show() {
        bigBoard.show();

        board.save();
    }

    public void show() {
        board.show();

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

