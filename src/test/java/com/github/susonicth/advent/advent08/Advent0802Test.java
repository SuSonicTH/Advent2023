package com.github.susonicth.advent.advent08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0802Test {
    public static final Path SAMPLE_FILE_3 = Path.of("./input/sample0803.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(6, new Advent0802().sumFile(SAMPLE_FILE_3));
    }
}

