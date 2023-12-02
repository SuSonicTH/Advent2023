package advent02;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static advent02.Advent02Test.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Advent0202Test {

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