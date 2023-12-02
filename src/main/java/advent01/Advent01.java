package advent01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Advent01 {
    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of("./input/input01.txt"))) {
            int answer = new Advent01().sumCalibrationNumbers(lines);
            System.out.println(answer);
        }
    }

    public int sumCalibrationNumbers(Stream<String> stream) {
        return stream
                .mapToInt(this::getNumber)
                .sum();
    }

    protected Integer getNumber(String line) {
        int first = 0;
        int last = 0;
        for (char c : line.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (first == 0) {
                    first = (c - '0') * 10;
                }
                last = (c - '0');
            }
        }
        return first + last;
    }
}
