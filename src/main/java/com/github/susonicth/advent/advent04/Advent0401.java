package com.github.susonicth.advent.advent04;

import com.github.susonicth.advent.Advent;

public class Advent0401 extends Advent {

    @Override
    protected long mapLineToNumber(String line) {
        return new Card(line).getScore();
    }

}

