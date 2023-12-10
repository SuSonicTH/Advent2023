package com.github.susonicth.advent.advent07;

import com.github.susonicth.advent.Advent;

import java.util.stream.Stream;

public class Advent0701 extends Advent {
    private int rank = 1;

    boolean withJoker() {
        return false;
    }

    @Override
    public long sumLines(Stream<String> stream) {
        return stream.map(line -> new Play(line, withJoker())).sorted().mapToInt(this::getWinning).sum();
    }

    private int getWinning(Play play) {
        return (rank++) * play.bid;
    }

}

