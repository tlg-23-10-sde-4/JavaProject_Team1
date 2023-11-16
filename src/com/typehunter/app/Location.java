package com.typehunter.app;

import com.typehunter.Animal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum Location {
    FOREST(1, new String[6]),
    TUNDRA(2, new String[12]),
    SAVANNA(3, new String[24]), ;

    //FIELDS
    private final int level;
    private final String [] wordCount;

    private List<Animal> animalWords; // list of animals
    private Animal animalCreated;       //

    Location(int level, String[] wordCount) {
        this.level = level;
        System.out.printf("LEVEL %s: %s", getLevel(), Location.this);
        this.wordCount = wordCount;
        this.animalWords = null;
        initializeAnimal();
    }

    public void initializeAnimal() {            //should create 3 instances of an Animal object
        for(int i=0; i < 3; i++) {
            new Animal(animalCreated.getName(), animalCreated.getImage(),
                    animalCreated.getSound(),animalCreated.getSize());
        }
    }

    //ACCESSOR
    public int getLevel() {
        return level;
    }

    public String[] getWordCount(){         //sets the wordCount[] based on level
        //animalWords = wordCount;
        return wordCount;
    }

    //methods
    //********might not be necessary if shuffle occurs at animal******
   public void shuffleWords() {
       Collections.shuffle(animalWords);
   }

   public void getNextWord(){
        if (!animalWords.isEmpty() && animalWords.size() < (animalWords.size() - wordCount.length)) {
            animalWords.remove(0);
        }
        //TODO: link currentRound to animal
   }

   public boolean isComplete(){
        return animalWords.isEmpty();
   }
}