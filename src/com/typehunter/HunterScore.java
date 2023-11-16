package com.typehunter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class HunterScore implements  Serializable {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int errors;
    private long elapsedTime;


    public HunterScore() {

    }

    public HunterScore(int errors, long elapsedTime) {
        setErrors(errors);
        setElapsedTime(elapsedTime);

    }

    //Clock object might only be needed if we make a duration each round should last? ie. 30sec total?
//    public void Clock() {
//        Clock clock = new Clock();
//
//    }

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

    public void setErrors(int errors) {
        this.errors = errors;

    }

    //Calculates the difference in seconds between the startTimer() and endTime()
    public void setElapsedTime(long elapsedTime) {
        elapsedTime = Duration.between(startTime, endTime).getSeconds();

    }

    public  long getElapsedTime() {
        return elapsedTime;

    }
}