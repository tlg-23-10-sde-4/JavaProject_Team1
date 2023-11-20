package com.typehunter.app;

import com.apps.util.Console;

import javax.swing.*;

class Documents {
    public static void main(String[] args) {


        Documents doc = new Documents();
        doc.welcome();

    }

    private void welcome() {
        System.out.println("=============================================");
        System.out.println();
        System.out.println("            T Y P E - H U N T E R            ");
        System.out.println();
        System.out.println("=============================================");
        //TO DO: insert hunter type image below
        ImageIcon typeHunter = new ImageIcon("images/ascii-art.txt");
        System.out.println(typeHunter);
        Console.clear();
    }
}