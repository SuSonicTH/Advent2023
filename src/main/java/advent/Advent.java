package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public abstract class Advent {

    public int sumFile(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return sumLines(lines);
        }
    }

    public int sumLines(Stream<String> stream) {
        return stream.mapToInt(this::mapLineToNumber).sum();
    }

    protected abstract int mapLineToNumber(String line);

}
