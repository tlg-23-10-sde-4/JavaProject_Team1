package com.typehunter.app;
package com.typehunter;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.typehunter.Animal;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    //private
    Application typeHunterGame = new Application();
    private Animal animal;
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
        typeHunterGame.location.initializeAnimal();

        //TODO: place animal in "location"

    }

    private void start() {
    }

    private void game() {
    }
    public void playRound(){
        //9 rounds, 3 per location

    }

    private void save() {
    }

    private void exit() {
    }


    //accessors


    //toString
}