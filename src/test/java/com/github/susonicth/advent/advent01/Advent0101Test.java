package com.github.susonicth.advent.advent01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0101Test {

    @Test
    void twoDigitsReturnedLiterally() {
        assertEquals(12, new Advent0101().mapLineToNumber("12"));
    }

    @Test
    void firstAndLastDigitIsUsed() {
        assertEquals(12, new Advent0101().mapLineToNumber("198765432"));
    }

    @Test
    void zeroAndNineAreGatheredCorrectly() {
        assertEquals(90, new Advent0101().mapLineToNumber("90"));
    }

    @Test
    void lonelyDigitIsUsedForBoth() {
        assertEquals(77, new Advent0101().mapLineToNumber("7"));
    }

    @Test
    void charactersAreIgnored() {
        assertEquals(28, new Advent0101().mapLineToNumber("abc2ght3lgt8hhh"));
    }

    @Test
    void summingUpAStreamOfLinesGivesCorrectSum() throws IOException {
        assertEquals(142, new Advent0101().sumFile(Path.of("./input/sample0101.txt")));
    }
}