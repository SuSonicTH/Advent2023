package com.github.susonicth.advent.advent03;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0302Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0301.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(467835, new Advent0302().sumFile(SAMPLE_FILE));
    }
}