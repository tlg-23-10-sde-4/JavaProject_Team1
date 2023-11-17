package com.typehunter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoard implements Serializable {
    private String name;
    private static final String dataFilePath = "leaderboard/leaderboard.dat";
    private final Map<String, HunterScore> scoreMap = new TreeMap<>();
    private HunterScore score;
    // create map of String(huntername) and HunterScore(int and long)

    public static LeaderBoard getInstance() throws IOException {
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
        Comparator<String> comparator = (name1, name2) -> {

            long elapsedTime1 = scoreMap.get(name1).getElapsedTime();
            long elapsedTime2 = scoreMap.get(name2).getElapsedTime();
            if(elapsedTime1 == elapsedTime2) {
                int errorCount1 = scoreMap.get(name1).getErrors();
                int errorCount2 = scoreMap.get(name2).getErrors();
                return Integer.compare(errorCount2, errorCount1);
            }
            return Long.compare(elapsedTime2, elapsedTime1);
        };
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
                String name = entry.getKey();
                HunterScore hunterScore = entry.getValue();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}