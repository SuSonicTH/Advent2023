package com.github.susonicth.advent.advent10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent1001Test {
    public static final Path SAMPLE_FILE_1 = Path.of("./input/sample1001.txt");
    public static final Path SAMPLE_FILE_2 = Path.of("./input/sample1002.txt");


    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(4, new Advent1001().sumFile(SAMPLE_FILE_1));
        assertEquals(8, new Advent1001().sumFile(SAMPLE_FILE_2));
    }
}

