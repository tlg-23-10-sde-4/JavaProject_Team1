package com.typehunter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

//TODO: Create a method that increments count of errors based off prompts to retry
public class HunterScore implements Comparable<HunterScore>, Serializable {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int errors = 0;
    private long elapsedTime = 0L;


    public HunterScore() {

    }

     HunterScore(int errors, long elapsedTime) {
       this.errors = errors;
       this.elapsedTime = elapsedTime;
    }

    //Starts timer when round starts and grabs and stores current time
    public void startTimer() {
        startTime = LocalDateTime.now();
    }

    //Ends timer when round ends and grabs and stores current time
    public void endTimer() {
        endTime = LocalDateTime.now();

    }


    public int getErrors() {
        return errors;

    }

    //Calculates the difference in seconds between the startTimer() and endTime()
    public void setElapsedTime(long elapsedTime ) {
        elapsedTime = Duration.between(startTime, endTime).getSeconds();

    }

    public  long getElapsedTime() {
        return elapsedTime;

    }
    public int compareTo(HunterScore other) {
        int result = Long.compare(this.getElapsedTime(), other.getElapsedTime());
        if (result == 0) {
            return Integer.compare(this.getErrors(), other.getErrors());
        }
        return result;
    }
}