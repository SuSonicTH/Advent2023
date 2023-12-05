package com.github.susonicth.advent.advent05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Advent0501Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0501.txt");

    @Test
    void seedAreMappedCorrectlyToLocation() throws IOException {
        Advent0501 advent0501 = new Advent0501();
        advent0501.loadFile(SAMPLE_FILE);

        assertEquals(82, advent0501.getLocation(79));
        assertEquals(43, advent0501.getLocation(14));
        assertEquals(86, advent0501.getLocation(55));
        assertEquals(35, advent0501.getLocation(13));
    }

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(35, new Advent0501().sumFile(SAMPLE_FILE));
    }
}

