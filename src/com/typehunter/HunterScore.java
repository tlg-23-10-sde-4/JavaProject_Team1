package com.typehunter;

class HunterScore {
    private int errors;
    private long elapsedTime;

    public HunterScore(int errors, long elapsedTime){
        this.errors = errors;
        this.elapsedTime = elapsedTime;

    }

    public int getErrors(){
        return errors;

    }

    public long getElapsedTime(){
        return elapsedTime;
    }

}