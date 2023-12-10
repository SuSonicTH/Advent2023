package com.github.susonicth.advent.advent08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0801Test {
    public static final Path SAMPLE_FILE_1 = Path.of("./input/sample0801.txt");
    public static final Path SAMPLE_FILE_2 = Path.of("./input/sample0802.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(2, new Advent0801().sumFile(SAMPLE_FILE_1));
        assertEquals(6, new Advent0801().sumFile(SAMPLE_FILE_2));
    }
}

