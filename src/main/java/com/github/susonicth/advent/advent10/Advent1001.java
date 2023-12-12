package com.github.susonicth.advent.advent10;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Path;

public class Advent1001 extends Advent {

    @Override
    public long sumFile(Path file) throws IOException {
        return new Grid(file).getLongestDistance();
    }
}

