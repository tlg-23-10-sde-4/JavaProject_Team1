package com.typehunter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LeaderBoard implements Serializable {
    private String name;
    private static final String dataFilePath = "leaderboard/leaderboard.dat";
    private List<Hunter> hunters;

    public LeaderBoard(List<Hunter> hunters) {
        this.hunters = hunters;
    }


    //Creates instance of LeaderBoard if there isnt one already. If there is then reads from file.
    public LeaderBoard getInstance() {
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

   private  LeaderBoard() {

    }

    /*SCOTTT NOTE:
     *I think it i decided not to use the treeMap named scoreMap
     * Hunter has a score and errors so  i think those might be included when
     * Leaderboard(List<Hunter> hunters) is constructed above.
     */


    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        } catch (Exception e) {
        }
    }

    public void show() {
        hunters.sort(null);
        for (Hunter hunter : hunters) {
            System.out.println("Name:" + hunter.getName() + " Time:" + hunter.getElapsedTime() + " Errors:" + hunter.getErrors());
        }
    }
}