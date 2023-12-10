package com.github.susonicth.advent.advent09;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0901Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0901.txt");

    @Test
    void sampleLinesAreMatching() throws IOException {
        assertArrayEquals(new Long[]{18L, 28L, 68L},
                Files.readAllLines(SAMPLE_FILE).stream().map(line -> new History(line).getNext()).toArray()
        );
    }

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(114, new Advent0901().sumFile(SAMPLE_FILE));
    }
}

