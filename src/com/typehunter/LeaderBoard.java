package com.typehunter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LeaderBoard implements Serializable {
    private String name;
    private static final String dataFilePath = "leaderboard/leaderboard.dat";
    private final Map<String, HunterScore> scoreMap = new TreeMap<>();
    private List<HunterScore> scores;

    public LeaderBoard(List<HunterScore> scores) {
        this.scores = scores;
    }

    //Creates instance of LeaderBoard if there isnt one already. IUf there is then reads from file.
    public static LeaderBoard getInstance() {
        LeaderBoard board = null;
        if (Files.exists(Path.of(dataFilePath))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (LeaderBoard) in.readObject();

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            board = new LeaderBoard();
        }
        return board;
    }

    private LeaderBoard() {

    }
    public void addScore(String name, HunterScore score) {
        scoreMap.put(name, score);
    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        }
        catch (Exception e) {
        }
    }

    public void show() {
        scores.sort(null);
        for (HunterScore score : scores) {
            System.out.println("Name:" + score.getHunterName() + " Time:" + score.getElapsedTime() + " Errors:" + score.getErrors());
        }
    }
}