package com.github.susonicth.advent.advent08;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Network2 extends Network {
    private List<Entry> entries;
    private List<Integer> loop;


    public Network2(Path file) throws IOException {
        super(file);
    }

    public long navigate() {
        entries = getStartingEntries();
        loop = new ArrayList<>(entries.size());
        for (int i = 0; i < entries.size(); i++) {
            loop.add(0);
        }
        while (notAllAtEnd(steps)) {
            for (int i = 0; i < entries.size(); i++) {
                entries.set(i, map.get(entries.get(i).directions[instructions[current_instruction]]));
            }
            nextStep();
        }

        return lowestCommonMultiple();
    }

    private long lowestCommonMultiple() {
        long result = loop.get(0);
        for (int i = 1; i < loop.size(); i++) {
            result = lowestCommonMultiple(result, loop.get(i));
        }
        return result;
    }

    public long greatestCommonDivisor(long a, long b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }

    private long lowestCommonMultiple(long a, long b) {
        return a * (b / greatestCommonDivisor(a, b));
    }

    private List<Entry> getStartingEntries() {
        return map.values().stream().filter(e -> e.id.endsWith("A")).collect(Collectors.toList());
    }

    private boolean notAllAtEnd(int steps) {
        for (int i = 0; i < entries.size(); i++) {
            if (loop.get(i) == 0 && entries.get(i).id.endsWith("Z")) {
                loop.set(i, steps);
            }
        }
        return loop.stream().anyMatch(i -> i == 0);
    }
}
