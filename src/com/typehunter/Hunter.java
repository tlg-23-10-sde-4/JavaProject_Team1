package com.typehunter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;


public class Hunter implements Comparable<Hunter>, Serializable {
    private String name;
    private static LocalDateTime startTime;
    private static LocalDateTime endTime;
    private int errors = 0;
    private long elapsedTime = 0L;
    private final long serialVersionUID = 1L;
    private int totalErrors = 0;

    public Hunter() {

    }

    public Hunter(String name) {
        this.name = name;
    }

    public Hunter(String name, int errors, long elapsedTime) {
        this.name = getName();
        this.errors = getErrors();
        this.elapsedTime = getElapsedTime();

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;

    }

    //Starts timer when round starts and grabs and stores current time
    public void startTimer() {
        startTime = LocalDateTime.now();
    }

    public void endTimer() {
        endTime = LocalDateTime.now();
        elapsedTime = Duration.between(startTime, endTime).getSeconds();
    }

    // SCOTT NOTE: This might be wrong. i think it might need to iterate errors then save itself
    public void incrementErrors() {
        totalErrors = errors++;
    }

    public int getErrors() {
        return totalErrors;

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