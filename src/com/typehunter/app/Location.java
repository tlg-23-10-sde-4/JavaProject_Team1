package com.typehunter.app;

import com.typehunter.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum Location {
    FOREST(1, new String[6]),
    TUNDRA(2, new String[12]),
    SAVANNA(3, new String[24]), ;

    //FIELDS
    private final int level;
    private final in numWords;
    private final List<String> words;   // 6, 12, or 24 words; depending on the level
    private List<Animal> animalWords = new ArrayList<>(); // list of animals

    private final String [] wordCount;

    Location(int level, String[] wordCount) {
        this.level = level;
        System.out.printf("LEVEL %s: %s", getLevel(), Location.this);
        this.wordCount = wordCount;
        this.animalWords = null;
        initializeAnimal(level);
    }

    public void initializeAnimal(int currentLevel) {            //should create 3 instances of an Animal object
        if(level == currentLevel) {
            for(int i=0; i < 3; i++) {
            animalWords.add(new Animal("Name", "Image", "Sound", "Size"));

//            new Animal( animalCreated.getName(), animalCreated.getImage(),
//                    animalCreated.getSound(),animalCreated.getSize());
            }
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
    //
    public static Location getLocationByLevel(int level){
        for (Location location : Location.values()) {
            if(location.getLevel() == level) {
                return location;
            }
        }
        return null;
    }

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