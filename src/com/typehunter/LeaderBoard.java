//package com.typehunter;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;
//
//
//public class LeaderBoard implements Serializable {
//    private String name;
//    private static final String dataFilePath = "resourceFiles/images/leaderboard2.txt";
//    private List<Hunter> hunters;
//
//    public LeaderBoard(List<Hunter> hunters) {
//        this.hunters = hunters;
//    }
//
//    public static LeaderBoard getInstance() {
//        LeaderBoard board = null;
//        if (Files.exists(Path.of(dataFilePath))) {
//            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
//                if (in.available() > 0) {
//                    board = (LeaderBoard) in.readObject();
//                } else {
//                    System.out.println("Board file is empty");
//                }
//            } catch (EOFException e) {
//                System.out.println("End of file reached");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if (board == null) {
//            board = new LeaderBoard(new ArrayList<>());  // Initialize the leaderboard with an empty list
//        }
//        return board;
//    }
//
//    public LeaderBoard() {
//
//    }
//
//    public void save() {
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
//            out.writeObject(hunters);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void show() {
//        if (hunters != null) {
//            hunters.sort(null);
//            for (Hunter hunter : hunters) {
//                System.out.println("Name:" + hunter.getName() + " Time:" + hunter.getElapsedTime() + " Errors:" + hunter.getErrors());
//            }
//        }
//        else{
//                System.out.println("Leaderboard is empty.");
//            }
//        }
//    public Hunter findPlayer(String playerName) {
//        if (hunters != null) {
//            for (Hunter hunter : hunters) {
//                if (hunter != null && hunter.getName().equalsIgnoreCase(playerName)) {
//                    return hunter;
//                }
//            }
//        }
//        return null;
//    }
//
//
//    public void addPlayer(Hunter player) {
//        if (hunters != null) {
//            hunters.add(player);
//        } else {
//            System.out.println("The leaderboard is initializing.");
//            if (hunters == null) {
//                hunters = new ArrayList<>(); // Initialize the leaderboard if not already initialized
//            }
//            hunters.add(player);
//
//        }
//    }
//}