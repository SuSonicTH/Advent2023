
package com.github.susonicth.advent.advent06;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Advent0601 extends Advent {

    @Override
    public int sumFile(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        List<Long> times = readNumbers(lines.get(0));
        List<Long> distance = readNumbers(lines.get(1));

        int sum = 1;
        for (int i = 0; i < times.size(); i++) {
            sum *= getWinningMoves(times.get(i), distance.get(i));
        }
        return sum;
    }

    private int getWinningMoves(Long time, Long distance) {
        int count = 0;
        for (int i = 1; i < time - 1; i++) {
            if (i * (time - i) > distance) {
                count++;
            }
        }
        return count;
    }

    private List<Long> readNumbers(String line) {
        return Arrays.stream(line.replaceAll(" +", "     ").split(" "))
                .skip(1)
                .map(Long::parseLong)
                .toList();
    }

}

