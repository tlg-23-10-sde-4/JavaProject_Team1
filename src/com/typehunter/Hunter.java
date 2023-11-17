package com.typehunter;

import java.io.Serializable;
import java.util.*;

public class Hunter {
   // Map<String, HunterScore> hunterScoreMap = new HashMap<>();
    private  String name;



    private Hunter(String name) {
        setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public static Hunter createHunter(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter your name!");
        }
        return new Hunter(name);
    }
}