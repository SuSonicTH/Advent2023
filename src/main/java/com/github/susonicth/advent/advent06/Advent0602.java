
package com.github.susonicth.advent.advent06;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Advent0602 extends Advent {

    @Override
    public int sumFile(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);

        long time = readNumbers(lines.get(0));
        long distance = readNumbers(lines.get(1));

        int count = 0;
        for (int i = 1; i < time - 1; i++) {
            if (i * (time - i) > distance) {
                count++;
            }
        }
        return count;
    }

    private long readNumbers(String line) {
        return Long.parseLong(line.replaceAll(" ", "").split(":")[1]);
    }

}

