package advent01;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0102Test {
    @Test
    void textualNumbersAreMatched() {
        assertEquals(12, new Advent0102().getNumber("onetwo"));
        assertEquals(34, new Advent0102().getNumber("threefour"));
        assertEquals(56, new Advent0102().getNumber("fivesix"));
        assertEquals(78, new Advent0102().getNumber("seveneight"));
        assertEquals(91, new Advent0102().getNumber("nineone"));
    }

    @Test
    void digitsAreMatchedCorrectly() {
        assertEquals(12, new Advent0102().getNumber("12"));
        assertEquals(34, new Advent0102().getNumber("34"));
        assertEquals(56, new Advent0102().getNumber("56"));
        assertEquals(78, new Advent0102().getNumber("78"));
        assertEquals(91, new Advent0102().getNumber("91"));
    }

    @Test
    void nonNumberCharactersAreIgnored() {
        assertEquals(12, new Advent0102().getNumber("asdsadonesdfgfdgtwodfgdfg"));
        assertEquals(12, new Advent0102().getNumber("asd1hjk2hjk"));
    }

    @Test
    void sampleInputIsParsedCorrectly() {
        assertEquals(29, new Advent0102().getNumber("two1nine"));
        assertEquals(83, new Advent0102().getNumber("eightwothree"));
        assertEquals(13, new Advent0102().getNumber("abcone2threexyz"));
        assertEquals(24, new Advent0102().getNumber("xtwone3four"));
        assertEquals(42, new Advent0102().getNumber("4nineeightseven2"));
        assertEquals(14, new Advent0102().getNumber("zoneight234"));
        assertEquals(76, new Advent0102().getNumber("7pqrstsixteen"));
    }

    @Test
    void sampleInputIsParsedCorrectly1() {
        assertEquals(18, new Advent0102().getNumber("oneight"));
    }

    @Test
    void sampleInputIsCalculatedCorrectly() {
        assertEquals(281, new Advent0102().sumCalibrationNumbers(
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