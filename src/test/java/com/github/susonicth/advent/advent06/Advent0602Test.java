package com.github.susonicth.advent.advent06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0602Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0601.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(71503, new Advent0602().sumFile(SAMPLE_FILE));
    }
}

