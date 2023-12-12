package com.github.susonicth.advent.advent10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent1002Test {
    public static final Path SAMPLE_FILE_1 = Path.of("./input/sample1003.txt");
    public static final Path SAMPLE_FILE_2 = Path.of("./input/sample1004.txt");
    public static final Path SAMPLE_FILE_3 = Path.of("./input/sample1005.txt");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(4, new Advent1002().sumFile(SAMPLE_FILE_1));
        assertEquals(8, new Advent1002().sumFile(SAMPLE_FILE_2));
        assertEquals(10, new Advent1002().sumFile(SAMPLE_FILE_3));
    }
}


