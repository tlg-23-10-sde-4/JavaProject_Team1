package com.typehunter.app;

enum Location {
    FOREST(1, new String[6]),
    TUNDRA(2, new String[12]),
    SAVANNA(3, new String[24]);

    //FIELDS
    private final int level;
    private final String [] wordCount;

    //ACCESSOR
    public int getLevel() {
        if( this.level == Location.FOREST.level){
            //code
            System.out.println("You are on level");
        }
        else if (this.level == Location.TUNDRA.level){
            //code
        }
        else if (this.level == Location.SAVANNA.level){
            //code
        }
        return level;
    }

    public String[] getWordCount() {
        return wordCount;
    }

    //methods
    Location(int difficulty, String[] wordCount) {
        this.level = difficulty;
        this.wordCount = wordCount;
//    }
//    public void self(int self){
//        if (self == 1) {


        }
    }
}