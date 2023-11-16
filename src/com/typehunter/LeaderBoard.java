package com.typehunter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.util.*;

public class LeaderBoard implements Comparable<HunterScore>, Serializable {
    private String name;
    private HunterScore score;
    // create map of String(huntername) and HunterScore(int and long)
    public HunterScore scores1 = new HunterScore(5, 20L);
    public HunterScore scores2 = new HunterScore(6, 20L);



    public static LeaderBoard getInstance() {
        LeaderBoard board = null;
        if (Files.exists(Path.of(ADD FILE PATH))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ADD FILE PATH))) {
                board = (LeaderBoard) in.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new LeaderBoard();
        }
        return board;
    }

    private final Map<String , HunterScore> scoreMap = new HashMap<>();

    private LeaderBoard() {

    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ADD FILE PATH))) {
            out.writeObject(this);
        } catch (Exception e) {

        }
    }

    public void show() {

    }

    public int compareTo(HunterScore other) {
        return Integer.compare((int) this.score.getElapsedTime(), (int) other.getElapsedTime());
    }
}