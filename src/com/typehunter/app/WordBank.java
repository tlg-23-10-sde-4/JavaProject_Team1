package com.typehunter.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WordBank {
    /*private*/ static List<String> allWords;

    public static List<String> getWords() {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < getWords().size(); i++) {
            words.add(allWords.remove(0));
        }
        return words;
    }

    static {
        try {
            allWords = Files.readAllLines(Path.of("resourceFiles/wordBank.txt"));
            Collections.shuffle(allWords);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}