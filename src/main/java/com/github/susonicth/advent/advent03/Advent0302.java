package com.github.susonicth.advent.advent03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class Advent0302 extends Advent0301 {
    @Override
    public int sumFile(Path file) throws IOException {
        int sum = 0;
        lines = Files.readAllLines(file);
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (getType(x, y) == CharType.GEAR) {
                    sum += getGearRatio(x, y);
                }
            }
        }
        return sum;
    }

    private int getGearRatio(int x, int y) {
        Set<Number> adjacentNumbers = getAdjacentNumbers(x, y);
        if (adjacentNumbers.size() == 2) {
            return adjacentNumbers.stream().mapToInt(Number::number).reduce(1, (a, b) -> a * b);
        }
        return 0;
    }

    @Override
    protected CharType getType(int x, int y) {
        return CharType.getFromCharWithGear(getCharAt(x, y));
    }

}
