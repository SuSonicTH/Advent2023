package com.github.susonicth.advent.advent07;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0701Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0701.txt");

    @Test
    void rankedCorrectly() throws IOException {
        List<String> expected = Arrays.asList("32T3K", "KTJJT", "KK677", "T55J5", "QQQJA");
        List<String> actual = Files.readAllLines(SAMPLE_FILE).stream().map(line -> new Play(line, false)).sorted().map(p -> p.cards).toList();
        assertEquals(expected, actual);
    }

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(6440, new Advent0701().sumFile(SAMPLE_FILE));
    }
}

