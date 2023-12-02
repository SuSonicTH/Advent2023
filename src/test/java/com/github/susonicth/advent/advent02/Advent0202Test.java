package com.github.susonicth.advent.advent02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static com.github.susonicth.advent.advent02.Advent0201Test.SAMPLE_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0202Test {

    @Test
    void powerIsCalculatedCorrectly() throws IOException {
        List<String> lines = Files.readAllLines(SAMPLE_FILE);
        assertEquals(48, new Game(lines.get(0)).getMinimum().power());
        assertEquals(12, new Game(lines.get(1)).getMinimum().power());
        assertEquals(1560, new Game(lines.get(2)).getMinimum().power());
        assertEquals(630, new Game(lines.get(3)).getMinimum().power());
        assertEquals(36, new Game(lines.get(4)).getMinimum().power());
    }

    @Test
    void sumIsCalculatedCorrectly() throws IOException {
        assertEquals(2286, new Advent0202().sumFile(SAMPLE_FILE));
    }
}