package com.typehunter;
import com.typehunter.app.WordBank;

import java.util.ArrayList;

public class Animal {

    public String name;
    public ArrayList<String> words;

    public Animal(String name, int amountOfWords) {
        this.name = name;
        this.words = WordBank.getRandomWords(amountOfWords);
    }

}
