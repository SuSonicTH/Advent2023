package com.github.susonicth.advent.advent04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0402Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0402.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(30, new Advent0402().sumFile(SAMPLE_FILE));
    }
}

