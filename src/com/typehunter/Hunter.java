package com.typehunter;

import java.io.Serializable;
import java.util.*;

class Hunter {
   // Map<String, HunterScore> hunterScoreMap = new HashMap<>();
    private  String name;



    public Hunter(String name) {
        setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
}