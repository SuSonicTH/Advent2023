package advent02;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static advent02.Advent02Test.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0202Test {

    @Test
    void minimumsAreCalculatedCorrectly() {
        assertEquals("Round{red=4, green=2, blue=6}", new Game(GAME_1).getMinimum().toString());
        assertEquals("Round{red=1, green=3, blue=4}", new Game(GAME_2).getMinimum().toString());
        assertEquals("Round{red=20, green=13, blue=6}", new Game(GAME_3).getMinimum().toString());
        assertEquals("Round{red=14, green=3, blue=15}", new Game(GAME_4).getMinimum().toString());
        assertEquals("Round{red=6, green=3, blue=2}", new Game(GAME_5).getMinimum().toString());
    }

    @Test
    void powerIsCalculatedCorrectly() {
        assertEquals(48, new Game(GAME_1).getMinimum().power());
        assertEquals(12, new Game(GAME_2).getMinimum().power());
        assertEquals(1560, new Game(GAME_3).getMinimum().power());
        assertEquals(630, new Game(GAME_4).getMinimum().power());
        assertEquals(36, new Game(GAME_5).getMinimum().power());
    }

    @Test
    void sumIsCalculatedCorrectly() {
        assertEquals(2286, new Advent0202().sumLines(Stream.of(GAME_1, GAME_2, GAME_3, GAME_4, GAME_5)));
    }
}