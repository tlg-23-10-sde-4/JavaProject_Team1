package com.typehunter;

import java.util.*;

class Hunter {
    Map<String, HunterScore> hunterScoreMap = new HashMap<>();

    private final String hunter;

    //Creating hash map with String hunter as key
    // HunterScore object (containing int errors, long elapsedTime) as the value
   // TODO: Fill map with KEY String name and VALUE  int errors and long elapsedTime



    public Hunter(String name) {
        this.hunter = name;

    }



    public void getScore(){


    }


    public String getName() {
        return hunter;
    }
}