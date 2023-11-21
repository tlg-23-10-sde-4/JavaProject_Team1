package com.typehunter.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.typehunter.*;

import javax.swing.*;
import java.io.IOException;
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
        playerProfile();
        // Creates Game for the purposing of calling run() in game
        Game game = new Game();
        game.run();
        save();
        show();

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
        System.out.println("P = Play, E = Exit");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.matches("p")) {
            System.out.println("L O A D I N G . . . .");

        } else if (input.matches("e")) {

            System.out.println("Exiting");
            exit();

        } else {
            System.out.println("Please choose P to Play! Or E to Exit :( ");
        }
    }


    //SCOTT NOTE: i commented in here because i cant get to the result i want
    public void playerProfile() {
        System.out.println("Please enter your name!");
        String input = scanner.next().trim().toUpperCase(); // Save the input name to use for name for Hunter()

        System.out.println("Are you a new player? Y|N");
        String newPlayer = scanner.next().trim().toUpperCase();

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


    public void save() {
        ranking.save();
    }

    public void show() {
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