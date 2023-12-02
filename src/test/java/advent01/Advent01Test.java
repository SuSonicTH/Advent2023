package advent01;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent01Test {

    @Test
    void twoDigitsReturnedLiterally() {
        assertEquals(12, new Advent01().mapLineToNumber("12"));
    }

    @Test
    void firstAndLastDigitIsUsed() {
        assertEquals(12, new Advent01().mapLineToNumber("198765432"));
    }

    @Test
    void zeroAndNineAreGatheredCorrectly() {
        assertEquals(90, new Advent01().mapLineToNumber("90"));
    }

    @Test
    void lonelyDigitIsUsedForBoth() {
        assertEquals(77, new Advent01().mapLineToNumber("7"));
    }

    @Test
    void charactersAreIgnored() {
        assertEquals(28, new Advent01().mapLineToNumber("abc2ght3lgt8hhh"));
    }

    @Test
    void summingUpAStreamOfLinesGivesCorrectSum() {
        assertEquals(142, new Advent01().sumLines(
                Stream.of(
                        "1abc2",
                        "pqr3stu8vwx",
                        "a1b2c3d4e5f",
                        "treb7uchet"
                )));
    }
}