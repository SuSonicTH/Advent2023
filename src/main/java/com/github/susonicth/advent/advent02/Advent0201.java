package com.github.susonicth.advent.advent02;

import com.github.susonicth.advent.Advent;

public class Advent0201 extends Advent {

    @Override
    protected int mapLineToNumber(String line) {
        Game game = new Game(line);
        return game.isPossible() ? game.getId() : 0;
    }
}
