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
//TODO reference to a single prompted

public class Application {
    private Hunter player;
    private LeaderBoard ranking;
    private String correctWord;
    private String nextCorrectWord;
    private Animal currentAnimal;
    private Location currentLocation = null;
    private LeaderBoard bigBoard = new LeaderBoard();
    private Scanner scanner = new Scanner(System.in);
    private String rules = "resourceFiles/images/rules.txt";
    private String welcomeBanner = "resourceFiles/images/welcomebanner.txt";
    private String hunterArt = "resourceFiles/images/hunter.txt";
    public String nameInput;


    //methods
    public void execute() {
        welcome();
        rule();
        playerProfile();
        // Creates Game for the purposing of calling run() in game
//        Game game = new Game();
        Game game = new Game();
        game.run();
        save();
        show();
        playAgain();
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

        //Prompter begin = new Prompter(new Scanner(System.in));
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
        String newPlayerName;

        while (true) {
            System.out.println("Please enter your name!");
            nameInput = scanner.next().trim();

            // Validate name
            if (!nameInput.isEmpty()) {
                break; // Exit the loop if a valid name is provided
            } else {
                System.out.println("Invalid name. Please enter your name.");
            }
        }

        boolean validInput = false;
        do {
            System.out.println("Are you a new player? Y|N");
            newPlayerName = scanner.next().trim();

            // if new player, add the Hunter to our List<Hunter> file
            if (newPlayerName.matches("Y|y")) {
                player = new Hunter(nameInput);
                validInput = true;
            } else if (newPlayerName.matches("N|n")) {
                /*
                 * Match input name to names in List<Hunter>
                 */
                // Add your logic for existing players
                validInput = true;
            } else {
                System.out.println("Please enter Y for New Player or N for Existing Player");
            }
        } while (!validInput);
    }

    public void save() {
        bigBoard.save();
    }

    public void show() {
        bigBoard.show();
    }

    private void playAgain() {
        System.out.print("Do you want to play again? (Y/N): ");
        String input = scanner.next().trim().toUpperCase();
        if (input.matches("Y|y")) {
            Game game = new Game();
            game.run();

        } else if (input.matches("N|n")) {
            exit();
        } else {
            System.out.println("Please enter Y to Play again or N to Exit");
            String inputs = scanner.nextLine().trim().toUpperCase();

        }
    }

    private void exit() {
        System.out.println("Exiting Type-Hunter. Good-Bye!!");
        scanner.close();
        System.exit(0);
    }
}