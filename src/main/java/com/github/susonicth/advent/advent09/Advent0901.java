
package com.github.susonicth.advent.advent09;

import com.github.susonicth.advent.Advent;

public class Advent0901 extends Advent {

    @Override
    protected long mapLineToNumber(String line) {
        return new History(line).getNext();
    }
}

