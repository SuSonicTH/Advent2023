package com.github.susonicth.advent.advent05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeMapTest {
    private static final Path SAMPLE_FILE = Path.of("./input/sample0501.txt");
    private static RangeMap rangeMap;

    @BeforeAll
    static void beforeAll() throws IOException {
        List<String> lines = Files.readAllLines(SAMPLE_FILE);
        rangeMap = new RangeMap(lines, "seed-to-soil map");
    }


    @Test
    void existingEntriesAreMappedCorrectly() throws IOException {
        assertEquals(51, rangeMap.get(99));
        assertEquals(55, rangeMap.get(53));
        assertEquals(81 , rangeMap.get(79));
        assertEquals(57 , rangeMap.get(55));
    }

    @Test
    void nonExistingEntriesAreMappedToInput() throws IOException {
        assertEquals(13 , rangeMap.get(13));
        assertEquals(14 , rangeMap.get(14));
    }
}