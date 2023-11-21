package com.typehunter.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.typehunter.*;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;


public class Application {
    private Hunter player;

    private String correctWord;
    private String nextCorrectWord;
    private Animal currentAnimal;
    private Location currentLocation = null;
    private Scanner scanner = new Scanner(System.in);
    private String rules = "resourceFiles/images/rules.txt";
    private String welcomeBanner = "resourceFiles/images/welcomebanner.txt";
    private String hunterArt = "resourceFiles/images/hunter.txt";
    public String nameInput;


    //methods
    public void execute() {
        welcome();
        rule();
       // playerProfile();

        Game game = new Game();
        game.run();
        exit();

    }

    public void welcome() {
        displayAsciiArtFromFile(welcomeBanner);
        displayAsciiArtFromFile(hunterArt);
        System.out.println("Enter any key to continue!");
        String input = scanner.nextLine();

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
        // displays rules
        displayAsciiArtFromFile(rules);
        System.out.println("L O A D I N G . . . .");
        System.out.println("Game will start in 10 seconds!");
        Console.pause(10000L);
    }


    //SCOTT NOTE: i commented in here because i cant get to the result i want
//    public void playerProfile() {
//        String newPlayerName;
//
//        while (true) {
//            Console.clear();
//            System.out.println("Please enter your name!");
//            nameInput = scanner.next().trim();
//
//            // Validate name
//            if (!nameInput.isEmpty()) {
//                break; // Exit the loop if a valid name is provided
//            } else {
//                System.out.println("Invalid name. Please enter your name.");
//            }
//        }
//
//        boolean validInput = false;
//        do {
//            System.out.println("Are you a new player? Y|N");
//            newPlayerName = scanner.next().trim();
//
//
//            // if new player, add the Hunter to our List<Hunter> file
//            if (newPlayerName.matches("Y|y")) {
//                Console.clear();
//                validInput = true;
//            } else if (newPlayerName.matches("N|n")) {
//                /*
//                 * Match input name to names in List<Hunter>
//                 */
//                // Add your logic for existing players
//                validInput = true;
//            } else {
//                System.out.println("Please enter Y for New Player or N for Existing Player");
//            }
//        } while (!validInput);
//        if (player != null) {
//            // Player found, use the existing player profile
//            System.out.println("Existing player profile loaded: " + player.getName());
//        } else {
//            // Player not found, create a new player profile
//            player = new Hunter(nameInput);
//            System.out.println("New player profile created: " + player.getName());
//        }
//    }
//
    private void exit() {
        System.out.println("Exiting Type-Hunter. Good-Bye!!");
        scanner.close();
        System.exit(0);
    }
}