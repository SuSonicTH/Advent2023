package com.github.susonicth.advent.advent07;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Advent0701 extends Advent {

    boolean withJoker() {
        return false;
    }

    @Override
    public int sumFile(Path file) throws IOException {
        int sum = 0;
        int rank = 1;
        for (Play play : Files.readAllLines(file).stream().map(line -> new Play(line, withJoker())).sorted().toList()) {
            sum += (rank++) * play.bid;
        }
        return sum;
    }
}

