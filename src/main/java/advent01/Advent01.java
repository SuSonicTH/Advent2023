package advent01;

import advent.Advent;

import java.io.IOException;
import java.nio.file.Path;

public class Advent01 extends Advent {
    public static void main(String[] args) throws IOException {
        System.out.println(new Advent01().sumFile(Path.of("./input/input01.txt")));
    }

    protected int mapLineToNumber(String line) {
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
