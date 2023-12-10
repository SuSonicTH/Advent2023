package com.github.susonicth.advent.advent01;

import com.github.susonicth.advent.Advent;

public class Advent0101 extends Advent {

    protected long mapLineToNumber(String line) {
        int first = 0;
        int last = 0;
        for (char c : line.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (first == 0) {
                    first = (c - '0') * 10;
                }
                last = (c - '0');
            }
        }
        return first + last;
    }
}
