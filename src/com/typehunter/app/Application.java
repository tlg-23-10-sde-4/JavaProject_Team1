package com.typehunter.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.typehunter.Animal;
import com.typehunter.Hunter;
import com.typehunter.HunterScore;
import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    //private
    Application typeHunterGame = new Application();
    private Animal animal;
    private int currentLevel;
    private Location location;


    //fields
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
        load();
        start();
        game();
        save();
        exit();
    }

    private void welcome() {
        System.out.println("=============================================");
        System.out.println();
        System.out.println("            T Y P E - H U N T E R            ");
        System.out.println();
        System.out.println("=============================================");
        //TO DO: insert hunter type image below
        ImageIcon typeHunter = new ImageIcon("images/hunter.png");
        System.out.println(typeHunter);
        Console.clear();
    }

    private void rule() {
        System.out.println("=============================================");
        System.out.println("      R U L E S   O F   T H E   G A M E      ");
        System.out.println("=============================================");
        System.out.println(rules);
        Prompter begin = new Prompter(new Scanner(System.in));
        String input = begin.prompt("P= play, E=exit, ", "\\d+", "Invalid Entry. P= play, E=exit");

        if(input.equals("P|p".toUpperCase())){
            load();
            start();
        }
        else {
            exit();
        }
    }

    private void load() {
        //TODO: load word bank
        typeHunterGame.animal.getWords();

        //TODO: create animals


        //TODO: place animal in "location"
        Location currentLocation = Location.getLocationByLevel(currentLevel);
        if(currentLocation != null) {
            currentLocation.initializeAnimal(currentLevel);
        }
        else {
            System.out.println(" Invalid level: " + currentLevel);
        }
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a  new player? Y|N");
        String isNewPlayer = scanner.next().trim().toUpperCase();

        int startingLevel = 1;
        int startingRound = 1;

        if(!isNewPlayer.equals("N")) {
            System.out.println("Enter your starting level (1, 2, or 3): ");
            startingLevel = getUserInput(scanner,1,3);

            System.out.println("Enter your starting round (1, 2, or 3): ");
            startingRound = getUserInput(scanner,1,3);
        }
        else {
            System.out.println("Happy Hunting!");
           // if(!isNewPlayer.equals("Y")) {
           //     startingLevel = 1;
           //     startingRound = 1;
        }
    }

    private int getUserInput(Scanner scanner, int min, int max) {
        int input = -1;
        boolean validInput = false;

        while(!validInput){
            if(scanner.hasNextInt()) {
                input =scanner.nextInt();
                if (input >= min && input <= max) {
                    validInput = true;
                }
            }
            else if(validInput) {
                System.out.println("Invalid input. Please enter a number between " + min+
                        " and " + max + ".");
                }
        else  {
            System.out.println("Invalid input. Please enter a valid number." );
            scanner.next();
            }
        }
        return input;
    }


    private void game() {
    }
    public void playRound(){
        //9 rounds, 3 per location

    }

    private void save() {
        //call on the method from Hunterscore
    }

    private void exit() {
        // prompter
        Console.clear();
    }


    //accessors


    //toString
}