package com.github.susonicth.advent.advent08;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Network {

    final int[] instructions;
    final Map<String, Entry> map = new HashMap<>();
    int steps = 0;
    int current_instruction = 0;

    public Network(Path file) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            instructions = bufferedReader.readLine().chars().map(c -> c == 'L' ? 0 : 1).toArray();
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Entry entry = new Entry(line);
                map.put(entry.id, entry);
            }
        }
    }

    public long navigate() {
        Entry entry = map.get("AAA");
        while (!entry.id.equals("ZZZ")) {
            entry = map.get(entry.directions[instructions[current_instruction]]);
            nextStep();
        }
        return steps;
    }

    void nextStep() {
        steps++;
        current_instruction++;
        if (current_instruction == instructions.length) {
            current_instruction = 0;
        }
    }
}
