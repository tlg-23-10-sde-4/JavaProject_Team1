package com.typehunter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.util.*;

public class LeaderBoard implements Comparable<HunterScore>, Serializable {
    private String name;
    private static final String dataFilePath = "leaderboard/leaderboard.dat";
    //private HashMap<String, HunterScore> hunterScores;
    private final Map<String, HunterScore> scoreMap = new HashMap<>();
    private HunterScore score;


    public static LeaderBoard getInstance() {
        LeaderBoard board = null;
        if (Files.exists(Path.of(dataFilePath))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (LeaderBoard) in.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new LeaderBoard();
        }
        return board;
    }
    // create map of String(huntername) and HunterScore(int and long)


    private LeaderBoard() {

    }

    public void addScore(String name, HunterScore score) {
        scoreMap.put(name, score);
    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        } catch (Exception e) {

        }
    }

    public void displayLeaderBoard() {
        for (String name : scoreMap.keySet()) {
            HunterScore hunterScore = scoreMap.get(name);
            System.out.println(name + ": " + score);
        }

    }

    public int compareTo(HunterScore other) {
        return Integer.compare((int) this.score.getElapsedTime(), (int) other.getElapsedTime());
    }
}