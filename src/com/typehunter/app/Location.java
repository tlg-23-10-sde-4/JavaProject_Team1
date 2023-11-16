package com.typehunter.app;

import com.typehunter.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

enum Location {
    FOREST(1, new String[6]),
    TUNDRA(2, new String[12]),
    SAVANNA(3, new String[24]), ;

    //FIELDS
    private final int level;
    private String [] wordCount = new String[0];
    private final List<Animal> animal;

    Location(int level, String[] wordCount) {
        this.level = level;
        System.out.printf("LEVEL %s: %s", getLevel(), Location.this);
        this.wordCount = wordCount;
        this.animal = null;
        initializeAnimal();
    }

    private void initializeAnimal() {
        for(int i=0; i < 3; i++) {
            animal.add(new Animal());
        }
    }


    //ACCESSOR
    public int getLevel() {
        return level;
    }

    public String[] getWordCount(){
        return wordCount;
    }

    //methods
   public void shuffleWords() {
       Collections.shuffle(animal);
   }

   public void getNextAnimal(){
        if (!animal.isEmpty()){
            animal.remove(0);
        }

   }

   public boolean isComplete(){
        return animal.isEmpty();
   }

}