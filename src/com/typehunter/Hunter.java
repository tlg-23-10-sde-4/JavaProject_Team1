package com.typehunter;

import java.io.Serializable;
import java.util.*;

public class Hunter {
   // Map<String, HunterScore> hunterScoreMap = new HashMap<>();
    private  String name;
    private HunterScore score;


    private Hunter(String name) {
       this.name = name;
       score = new HunterScore(name);

    }

    public String getName() {
        return name;
    }

}