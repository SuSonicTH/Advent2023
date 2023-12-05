package com.github.susonicth.advent.advent05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Advent0502Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0502.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(0, new Advent0502().sumFile(SAMPLE_FILE));
    }
}

