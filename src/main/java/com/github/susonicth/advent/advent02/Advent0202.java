package com.github.susonicth.advent.advent02;

import com.github.susonicth.advent.Advent;

public class Advent0202 extends Advent {

    @Override
    protected long mapLineToNumber(String line) {
        return new Game(line).getMinimum().power();
    }
}
