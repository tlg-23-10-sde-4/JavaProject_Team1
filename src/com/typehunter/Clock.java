package com.typehunter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Clock {
    //private Clock clock = new Clock();
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long elapsedTime;

    //Clock object might only be needed if we make a duration each round should last? ie. 30sec total?
    public void Clock() {
        Clock clock = new Clock();

    }

    //Starts timer when round starts and grabs and stores current time
    public void startTimer(){
    startTime = LocalDateTime.now();
    }

    //Ends timer when round ends and grabs and stores current time
    public void endTimer() {
    endTime = LocalDateTime.now();

    }

    //Calculates the difference in seconds between the startTimer() and endTime()
    public void setElapsedTime(){
         elapsedTime = Duration.between(startTime, endTime).getSeconds();


    }
    public long getElapsedTime(){
        return elapsedTime;

    }
}