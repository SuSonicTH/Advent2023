package com.github.susonicth.advent.advent03;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Advent0301 extends Advent {
    private final Set<Number> numbers = new HashSet<>();
    protected List<String> lines;

    @Override
    public int sumFile(Path file) throws IOException {
        lines = Files.readAllLines(file);
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                if (getType(x, y) == CharType.SYMBOL) {
                    numbers.addAll(getAdjacentNumbers(x, y));
                }
            }
        }
        return numbers.stream().mapToInt(Number::number).sum();
    }

    protected CharType getType(int x, int y) {
        return CharType.getFromChar(getCharAt(x, y));
    }

    protected char getCharAt(int x, int y) {
        if (x < 0 || y < 0 || y > lines.size() - 1) {
            return '.';
        }

        String line = lines.get(y);
        if (x > line.length() - 1) {
            return '.';
        }
        return line.charAt(x);
    }

    protected Set<Number> getAdjacentNumbers(int x, int y) {
        Set<Number> numbers = new HashSet<>();
        for (int xc = x - 1; xc <= x + 1; xc++) {
            for (int yc = y - 1; yc <= y + 1; yc++) {
                if (isNumber(xc, yc)) {
                    numbers.add(getNumber(xc, yc));
                }
            }
        }
        return numbers;
    }

    protected boolean isNumber(int x, int y) {
        return getType(x, y) == CharType.NUMBER;
    }

    protected Number getNumber(int x, int y) {
        int start = x;
        while (isNumber(start - 1, y)) {
            start--;
        }
        int end = x;
        while (isNumber(end, y)) {
            end++;
        }
        return new Number(y, start, end, Integer.parseInt(lines.get(y).substring(start, end)));
    }
}
