package com.github.susonicth.advent.advent10;

public enum Direction {
    NORTH(new Vector(0, -1)),
    SOUTH(new Vector(0, 1)),
    EAST(new Vector(1, 0)),
    WEST(new Vector(-1, 0));

    public final Vector vector;

    Direction(Vector vector) {
        this.vector = vector;
    }
}
