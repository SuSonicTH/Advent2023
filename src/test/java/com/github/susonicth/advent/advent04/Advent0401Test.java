package com.github.susonicth.advent.advent04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0401Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0401.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(13, new Advent0401().sumFile(SAMPLE_FILE));
    }
}

