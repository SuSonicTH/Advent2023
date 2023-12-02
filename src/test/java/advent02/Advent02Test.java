package advent02;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Advent02Test {
    public static final String GAME_1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
    public static final String GAME_2 = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
    public static final String GAME_3 = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
    public static final String GAME_4 = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
    public static final String GAME_5 = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";

    @Test
    void gameIsParsedCorrectly() {
        assertEquals("Game{id=1, rounds=[Round{red=4, green=0, blue=3}, Round{red=1, green=2, blue=6}, Round{red=0, green=2, blue=0}]}",
                new Game(GAME_1).toString());
    }

    @Test
    void comparingToMaximum() {
        Round maximum = new Round(1, 2, 3);
        assertFalse(new Round(0, 0, 0).isMoreThen(maximum));
        assertFalse(new Round(1, 1, 1).isMoreThen(maximum));
        assertFalse(new Round(1, 2, 3).isMoreThen(maximum));

        assertTrue(new Round(2, 0, 0).isMoreThen(maximum));
        assertTrue(new Round(0, 3, 0).isMoreThen(maximum));
        assertTrue(new Round(0, 0, 4).isMoreThen(maximum));
    }

    @Test
    void gameIsPossibleEvaluatedCorrectly() {
        assertTrue(new Game(GAME_1).isPossible());
        assertTrue(new Game(GAME_2).isPossible());
        assertFalse(new Game(GAME_3).isPossible());
        assertFalse(new Game(GAME_4).isPossible());
        assertTrue(new Game(GAME_5).isPossible());
    }

    @Test
    void gamesAreSummedUpCorrectly() {
        assertEquals(8, new Advent02().sumLines(Stream.of(GAME_1, GAME_2, GAME_3, GAME_4, GAME_5)));
    }
}