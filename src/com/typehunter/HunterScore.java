package com.typehunter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;


public class HunterScore implements Comparable<HunterScore>, Serializable {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int errors = 0;
    private long elapsedTime = 0L;
    private String hunterName;

    HunterScore scores1 = new HunterScore();
    HunterScore scores2 = new HunterScore();

    public HunterScore(String hunterName) {
        this.hunterName = hunterName;
    }

    //Starts timer when round starts and grabs and stores current time
    public void startTimer() {
        startTime = LocalDateTime.now();
    }

    //Ends timer when round ends and grabs and stores current time
    public void endTimer() {
        endTime = LocalDateTime.now();

    }

    public String getHunterName() {
        return hunterName;
    }

    public int getErrors() {
        return errors;

    }

    public void setErrors(int errors) {
        this.errors = errors;

    }

    //Calculates the difference in seconds between the startTimer() and endTime()
    public void setElapsedTime(long elapsedTime ) {
        elapsedTime = Duration.between(startTime, endTime).getSeconds();

    }

    public  long getElapsedTime() {
        return elapsedTime;

    }
    public int compareTo(HunterScore other){
        int result = Long.compare(this.getElapsedTime(), other.getElapsedTime());
        if ()



//       if(this.getElapsedTime() == other.getElapsedTime()) {
//           return Integer.compare(this.getErrors(), other.getErrors());
//       }
//
//       return Long.compare(this.getElapsedTime(), other.getElapsedTime());


    }
}