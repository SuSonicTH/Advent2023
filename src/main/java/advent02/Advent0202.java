package advent02;

import advent.Advent;

import java.io.IOException;
import java.nio.file.Path;

public class Advent0202 extends Advent {

    public static void main(String[] args) throws IOException {
        System.out.println(new Advent0202().sumFile(Path.of("./input/input02.txt")));
    }

    @Override
    protected int mapLineToNumber(String line) {
        Game game = new Game(line);
        return game.getMinimum().power();
    }
}
