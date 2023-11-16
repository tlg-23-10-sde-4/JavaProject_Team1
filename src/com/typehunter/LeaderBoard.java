package com.typehunter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoard implements  Serializable {
    private String name;
    private static final String dataFilePath = "leaderboard/leaderboard.dat";
    private final Map<String, HunterScore> scoreMap = new TreeMap<>();
    private HunterScore score;
    // create map of String(huntername) and HunterScore(int and long)

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

    public void displayLeaderBoard() {
        for (Map.Entry<String, HunterScore> entry : scoreMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}