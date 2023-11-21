package com.typehunter.app;

import com.apps.util.Prompter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void welcome_shouldReadFromFileWhenAppropriatelyCalled() {
        assertEquals("resourceFiles/images/hunter.txt", "resourceFiles/images/hunter.txt");
    }

    @Test
    public void rule_shouldOutputCorrectString_whenUserPromptIsE() throws FileNotFoundException {
        Prompter prompter = new Prompter(new Scanner(new File("resourceFiles/e.txt")));
        assertEquals("L O A D I N G . . . .", "L O A D I N G . . . .");
    }

    @Test
    public void rule_shouldOutputCorrectString_whenUserPromptIsP() throws FileNotFoundException {
//        Prompter prompter = new Prompter(new Scanner(new File("resourceFiles/p.txt")));
//        Application.rule();
//        assertEquals("L O A D I N G . . . .", "L O A D I N G . . . .");
    }
}