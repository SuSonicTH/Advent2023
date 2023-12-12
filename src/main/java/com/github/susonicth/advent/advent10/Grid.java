package com.github.susonicth.advent.advent10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Grid {
    private static final byte EMPTY = 0;
    private static final byte FLIP_NORTH = 1;
    private static final byte PIPE = 2;

    private final List<List<Tile>> map;
    private final int columns;
    private final int rows;
    private final Position start;
    private final byte[][] loop;
    private int steps = 1;
    private Position position;
    private Direction direction;

    public Grid(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            map = lines.map(Grid::getRow).toList();
        }
        rows = map.size();
        columns = map.get(0).size();
        loop = new byte[rows][columns];

        start = getStartPosition();
        direction = getStartingDirectionAndSetPosition();
    }

    private static List<Tile> getRow(String line) {
        return line.chars().mapToObj(Tile::fromCharacter).toList();
    }

    private Position getStartPosition() {
        for (int y = 0; y < rows; y++) {
            List<Tile> row = map.get(y);
            for (int x = 0; x < columns; x++) {
                if (row.get(x) == Tile.START) {
                    return new Position(x, y);
                }
            }
        }
        return null;
    }

    private Direction getStartingDirectionAndSetPosition() {
        Direction[] directions = getStartingDirections();
        if (directions[0] == Direction.SOUTH || directions[1] == Direction.SOUTH) {
            loop[start.y()][start.x()] = FLIP_NORTH;
        } else {
            loop[start.y()][start.x()] = PIPE;
        }
        position = start.next(directions[0]);
        return directions[0];
    }

    private Direction[] getStartingDirections() {
        Direction[] directions = new Direction[2];
        int d = 0;
        for (Direction currentDirection : Direction.values()) {
            Position next = start.next(currentDirection);
            if (get(next).getNextDirection(currentDirection) != null) {
                directions[d++] = currentDirection;
            }
        }
        return directions;
    }

    private Tile get(Position position) {
        if (position.x() < 0 || position.x() >= columns || position.y() < 0 || position.y() >= rows) {
            return Tile.GROUND;
        }
        return map.get(position.y()).get(position.x());
    }

    public long getLongestDistance() {
        while (!position.equals(start)) {
            Tile tile = get(position);
            if (tile.flipsInsideOut) {
                loop[position.y()][position.x()] = FLIP_NORTH;
            } else {
                loop[position.y()][position.x()] = PIPE;
            }
            direction = tile.getNextDirectionOrThrow(direction);
            position = position.next(direction);
            steps++;
        }
        return steps / 2;
    }

    public long getEnclosingCount() {
        if (steps == 1) {
            getLongestDistance();
        }
        long count = 0;
        for (int y = 0; y < rows; y++) {
            boolean inside = false;
            byte[] row = loop[y];
            for (int x = 0; x < columns; x++) {
                if (row[x] == FLIP_NORTH) {
                    inside = !inside;
                } else if (row[x] == EMPTY && inside) {
                    count++;
                }
            }
        }
        return count;
    }

}
