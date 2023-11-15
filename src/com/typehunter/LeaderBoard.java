package com.typehunter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LeaderBoard implements Serializable {
    // create map of String(huntername) and HunterScore(int and long)

    public static LeaderBoard getInstance() {
        LeaderBoard board = null;
        if (Files.exists(Path.of(ADD FILE PATH))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ADD FILE PATH))) {
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

    private final Map<String, HunterScore> scoreMap = new HashMap<>();

    private LeaderBoard() {

    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ADD FILE PATH))){
            out.writeObject(this);
        }
        catch (Exception e) {

        }
    }

    public void show(){

    }
}