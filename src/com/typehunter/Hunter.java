package com.typehunter;

import java.io.Serializable;
import java.util.*;

public class Hunter implements Comparable<Hunter> {
    private  String name;
    private HunterScore score = new HunterScore();
    private Scanner scanner;

    //Creating a Hunter with name and a HunterScore object associated with name
    public Hunter(String name) {
        //assert false;
        this.name = name;
    }

    public HunterScore getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Hunter other) {
        int result = Long.compare(this.getScore().getElapsedTime(), other.getScore().getElapsedTime());

        if (result == 0) {
            result = Integer.compare(this.getScore().getErrors(), other.getScore().getErrors());
        }
        return result;
    }
}