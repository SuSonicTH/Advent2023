package com.github.susonicth.advent.advent07;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0702Test {
    public static final Path SAMPLE_FILE = Path.of("./input/sample0701.txt");

    @Test
    void rankedCorrectly() throws IOException {
        List<String> expected = Arrays.asList("32T3K", "KK677", "T55J5", "QQQJA", "KTJJT");
        List<String> actual = Files.readAllLines(SAMPLE_FILE).stream().map(line -> new Play(line, true)).sorted().map(p -> p.cards).toList();
        assertEquals(expected, actual);
    }

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(5905, new Advent0702().sumFile(SAMPLE_FILE));
    }
}

