package com.github.susonicth.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public abstract class Advent {

    public long sumFile(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return sumLines(lines);
        }
    }

    public long sumLines(Stream<String> stream) {
        return stream.mapToLong(this::mapLineToNumber).sum();
    }

    protected long mapLineToNumber(String line) {
        return 0;
    }

}
