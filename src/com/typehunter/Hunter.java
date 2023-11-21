package com.typehunter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

/*
 *SCOTT NOTE:
 * Kind of big change here. Ive decided ill scrap the HunterScore Class.
 * instead the "scores" (int errors and long elapsedTime) will just be fields in Hunter.
 * can still call compareTo() for natural order as listed below.
 *
 * When we call to show() for the LeaderBoard class it will be coded to show the hunter.getErrors, hunter.getElapsedTime
 * and such
 * i think that works
 */


public class Hunter implements Comparable<Hunter>, Serializable {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int errors = 0;
    private long elapsedTime = 0L;
    private static final long serialVersionUID = 1L;

    public Hunter(String name) {
        this.name = name;
    }

    public Hunter(String name, int errors, long elapsedTime) {
        this.name = getName();
        this.errors = getErrors();
        this.elapsedTime = getElapsedTime();

    }

    public String getName() {
        return name;

    }

    //Starts timer when round starts and grabs and stores current time
    public void startTimer() {
        startTime = LocalDateTime.now();
    }

    //Ends timer when round ends and grabs and stores current time
    // and calculates elapsedTime.
    //SCOTT NOTE: since its a long it might be crazy long. need to look into ways to shorten it down
    // like restricting it to a few decimal places
    public void endTimer() {
        endTime = LocalDateTime.now();
        elapsedTime = Duration.between(startTime, endTime).getSeconds();
    }

    // SCOTT NOTE: This might be wrong. i think it might need to iterate errors then save itself
    public void incrementErrors() {
        errors++;
    }

    public int getErrors() {
        return errors;

    }

    public long getElapsedTime() {
        return elapsedTime;

    }

    @Override
    public int compareTo(Hunter other) {
        int result = Long.compare(this.getElapsedTime(), other.getElapsedTime());

        if (result == 0) {  // tied on elapsedTime, so break the tie by errors
            result = Integer.compare(this.getErrors(), other.getErrors());
        }
        return result;
    }
}