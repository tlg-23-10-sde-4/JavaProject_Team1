package com.typehunter;

public class HunterScore {
    private int errors;
    private long elapsedTime;



    public HunterScore(int errors, long elapsedTime){
        setErrors(errors);


    }

    public int getErrors(){
        return errors;

    }

    public void setErrors(int errors) {
        this.errors = errors;

    }
}