package com.typehunter;

import java.io.Serializable;
import java.util.*;

public class Hunter {
    private  String name;
    private HunterScore score;

    //Creating a Hunter with name and a HunterScore object associated with name
    private Hunter(String name) {
       this.name = name;
       score = new HunterScore(name);
    }

    public HunterScore getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

}