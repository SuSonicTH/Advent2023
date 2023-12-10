package com.github.susonicth.advent.advent09;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0902Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0901.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(2, new Advent0902().sumFile(SAMPLE_FILE));
    }
}

