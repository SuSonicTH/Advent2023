package com.github.susonicth.advent.advent02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Advent0201Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0201.txt");

    @Test
    void comparingToMaximum() {
        Round maximum = new Round(1, 2, 3);
        assertFalse(new Round(0, 0, 0).isMoreThen(maximum));
        assertFalse(new Round(1, 1, 1).isMoreThen(maximum));
        assertFalse(new Round(1, 2, 3).isMoreThen(maximum));

        assertTrue(new Round(2, 0, 0).isMoreThen(maximum));
        assertTrue(new Round(0, 3, 0).isMoreThen(maximum));
        assertTrue(new Round(0, 0, 4).isMoreThen(maximum));
    }

    @Test
    void gameIsPossibleEvaluatedCorrectly() throws IOException {
        List<String> lines = Files.readAllLines(SAMPLE_FILE);
        assertTrue(new Game(lines.get(0)).isPossible());
        assertTrue(new Game(lines.get(1)).isPossible());
        assertFalse(new Game(lines.get(2)).isPossible());
        assertFalse(new Game(lines.get(3)).isPossible());
        assertTrue(new Game(lines.get(4)).isPossible());
    }

    @Test
    void gamesAreSummedUpCorrectly() throws IOException {
        assertEquals(8, new Advent0201().sumFile(SAMPLE_FILE));
    }
}