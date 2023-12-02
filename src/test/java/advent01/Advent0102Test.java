package advent01;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0102Test {
    @Test
    void textualNumbersAreMatched() {
        assertEquals(12, new Advent0102().mapLineToNumber("onetwo"));
        assertEquals(34, new Advent0102().mapLineToNumber("threefour"));
        assertEquals(56, new Advent0102().mapLineToNumber("fivesix"));
        assertEquals(78, new Advent0102().mapLineToNumber("seveneight"));
        assertEquals(91, new Advent0102().mapLineToNumber("nineone"));
    }

    @Test
    void digitsAreMatchedCorrectly() {
        assertEquals(12, new Advent0102().mapLineToNumber("12"));
        assertEquals(34, new Advent0102().mapLineToNumber("34"));
        assertEquals(56, new Advent0102().mapLineToNumber("56"));
        assertEquals(78, new Advent0102().mapLineToNumber("78"));
        assertEquals(91, new Advent0102().mapLineToNumber("91"));
    }

    @Test
    void nonNumberCharactersAreIgnored() {
        assertEquals(12, new Advent0102().mapLineToNumber("asdsadonesdfgfdgtwodfgdfg"));
        assertEquals(12, new Advent0102().mapLineToNumber("asd1hjk2hjk"));
    }

    @Test
    void sampleInputIsParsedCorrectly() {
        assertEquals(29, new Advent0102().mapLineToNumber("two1nine"));
        assertEquals(83, new Advent0102().mapLineToNumber("eightwothree"));
        assertEquals(13, new Advent0102().mapLineToNumber("abcone2threexyz"));
        assertEquals(24, new Advent0102().mapLineToNumber("xtwone3four"));
        assertEquals(42, new Advent0102().mapLineToNumber("4nineeightseven2"));
        assertEquals(14, new Advent0102().mapLineToNumber("zoneight234"));
        assertEquals(76, new Advent0102().mapLineToNumber("7pqrstsixteen"));
    }

    @Test
    void sampleInputIsParsedCorrectly1() {
        assertEquals(18, new Advent0102().mapLineToNumber("oneight"));
    }

    @Test
    void sampleInputIsCalculatedCorrectly() {
        assertEquals(281, new Advent0102().sumLines(
                Stream.of(
                        "two1nine",
                        "eightwothree",
                        "abcone2threexyz",
                        "xtwone3four",
                        "4nineeightseven2",
                        "zoneight234",
                        "7pqrstsixteen"
                )));
    }
}