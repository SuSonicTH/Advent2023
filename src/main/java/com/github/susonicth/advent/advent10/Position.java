package com.github.susonicth.advent.advent10;

public record Position(int x, int y) {

    public Position next(Direction direction) {
        return new Position(x + direction.vector.x(), y + direction.vector.y());
    }
}
