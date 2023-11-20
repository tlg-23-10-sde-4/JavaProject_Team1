package com.typehunter.app;

import com.typehunter.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.typehunter.app.WordBank.allWords;

/*
 * The game has different locations that is associated with the overall
 */
public enum Location {
    FOREST(1, 6),
    TUNDRA(2, 12),
    SAVANNA(3, 24);

    private static int level;
    //FIELDS
    //private final int level;
    private Location currentLocation;
    private static final List<String> wordsByLevel = null;
    private static final List<Animal> animalList = new ArrayList<>();

    //Static
    private static List<String> wordBank;

    private final int wordCount;

    private static List<String> getWordBank() {
        if (wordBank == null) {
            try {
                wordBank = Files.readAllLines(Path.of("resourceFiles/wordBank.txt"));
                Collections.shuffle(wordBank);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wordBank;
    }

    //CTORS
    Location(int level, int wordCount) {
        //this.level = level;
        this.wordCount = wordCount;
        //wordsByLevel = getWordBank().subList(0, wordCount);
        //initializeAnimal();
    }

    public static void initializeAnimal() {
        //should create 3 instances of an Animal object
        try {
            String animalFilePath;
            switch (getLocationByLevel(Application.location)) {
                case FOREST:
                    animalFilePath = "resourceFiles/forest.txt";
                    break;
                case TUNDRA:
                    animalFilePath = "resourcesFiles/tundra.txt";
                    break;
                case SAVANNA:
                    animalFilePath = "resourceFiles/savanna.txt";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + getLocationByLevel(Application.location));
            }

            for (int i = 0; i < 3; i++) {
                List<String> lines = Files.readAllLines(Path.of(animalFilePath));
                String[] tokens = lines.get(i).split(",");
                Animal animal = new Animal(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                animalList.add(animal);
            }
        } catch (IllegalStateException | NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    // SCOTT: Printing next level for user
    public Location nextLevel() {
        Location nextLocation = currentLocation.nextLevel();

        if (nextLocation != null) {
            System.out.println("Congratulation! You have completed the  " + currentLocation + level());
            System.out.println("Welcome to the " + nextLocation + level());
            setCurrentLocation(nextLocation);

        } else {
            System.out.println(" Congratulation! You have completed the " + currentLocation + level());
            System.out.println("You have completed all level! Congratulations Hunter!");
        }
        return null;
    }

    static int level() {
        return level;
    }


    // SCOTT: Trying to create a nextLevel step sequence
    public Location getNextLevel() {
        switch (this) {
            case FOREST:
                return TUNDRA;
            case TUNDRA:
                return SAVANNA;
            case SAVANNA:
                return null;
            default:
                throw new IllegalStateException("getNextLevel error");

        }
    }

    // SCOTT. added for nextLevel()
    private void setCurrentLocation(Location nextLocation) {
    }

    //ACCESSOR
    public static String nextWord() {
        return allWords.remove(0);
    }

    public int getWordCount() {
        return wordsByLevel.size();
    }

    public static Animal nextAnimal() {
        return animalList.remove(0);
    }

    public static boolean isComplete() {
        return animalList.get(0).isDead() &&
                animalList.get(1).isDead() &&
                animalList.get(2).isDead();
    }

    public static Location getLocationByLevel(int level) {
        for (Location location : Location.values()) {
            if (location.level() == level) {
                return location;
            }
        }
        return Location.getLocationByLevel(level);
    }
}




//public enum Location {
//    FOREST(1, new String[6]),
//    TUNDRA(2, new String[12]),
//    SAVANNA(3, new String[24]), ;
//
//    //FIELDS
//    private final int level;
//    private final int numWords;
//    private final List<String> words;   // 6, 12, or 24 words; depending on the level
//    private List<Animal> animalWords = new ArrayList<>(); // list of animals
//
//    private final String [] wordCount;
//
//    Location(int level, String[] wordCount) {
//        this.level = level;
//        System.out.printf("LEVEL %s: %s", getLevel(), Location.this);
//        this.wordCount = wordCount;
//        this.animalWords = null;
//        initializeAnimal(level);
//    }
//
//    public void initializeAnimal(int currentLevel) {            //should create 3 instances of an Animal object
//        if(level == currentLevel) {
//            for(int i=0; i < 3; i++) {
//            animalWords.add(new Animal("Name", "Image", "Sound", new String[]{""}));
//
////            new Animal( animalCreated.getName(), animalCreated.getImage(),
////                    animalCreated.getSound(),animalCreated.getSize());
//            }
//        }
//    }
//
//    //ACCESSOR
//    public int getLevel() {
//        return level;
//    }
//
//    public String[] getWordCount(){         //sets the wordCount[] based on level
//        //animalWords = wordCount;
//        return wordCount;
//    }
//
//    //methods
//    //
//    public static Location getLocationByLevel(int level){
//        for (Location location : Location.values()) {
//            if(location.getLevel() == level) {
//                return location;
//            }
//        }
//        return null;
//    }
//
//    //********might not be necessary if shuffle occurs at animal******
//   public void shuffleWords() {
//       Collections.shuffle(animalWords);
//   }
//
//   public void getNextWord(){
//        if (!animalWords.isEmpty()) {
//            animalWords.remove(0);
//        }
//        //Need to link currentRound to animal
//   }
//
//   public boolean isComplete(){
//        return animalWords.isEmpty();
//   }
//}