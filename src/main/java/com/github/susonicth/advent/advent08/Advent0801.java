package com.github.susonicth.advent.advent08;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Path;

public class Advent0801 extends Advent {

    @Override
    public long sumFile(Path file) throws IOException {
        return new Network(file).navigate();
    }
}

