package com.github.susonicth.advent.advent10;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public enum Tile {
    GROUND('.'),
    START('S'),
    NORT_SOUTH('|', Map.of(Direction.NORTH, Direction.NORTH, Direction.SOUTH, Direction.SOUTH), true),
    EAST_WEST('-', Map.of(Direction.EAST, Direction.EAST, Direction.WEST, Direction.WEST)),
    NORTH_EAST('L', Map.of(Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.NORTH)),
    NORTH_WEST('J', Map.of(Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.NORTH)),
    SOUTH_WEST('7', Map.of(Direction.EAST, Direction.SOUTH, Direction.NORTH, Direction.WEST), true),
    SOUTH_EAST('F', Map.of(Direction.NORTH, Direction.EAST, Direction.WEST, Direction.SOUTH), true);

    private static final Map<Integer, Tile> characterToTileMap = stream(values()).collect(toMap(k -> (int) k.character, v -> v));
    public final boolean flipsInsideOut;
    private final Character character;
    private final Map<Direction, Direction> directionMap;

    Tile(char character) {
        this(character, null, false);
    }

    Tile(char character, Map<Direction, Direction> directionMap) {
        this(character, directionMap, false);
    }

    Tile(char character, Map<Direction, Direction> directionMap, boolean flipsInsideOut) {
        this.character = character;
        this.directionMap = directionMap;
        this.flipsInsideOut = flipsInsideOut;
    }

    public static Tile fromCharacter(Integer character) {
        return characterToTileMap.get(character);
    }

    public Direction getNextDirection(Direction direction) {
        return directionMap == null ? null : directionMap.get(direction);
    }

    public Direction getNextDirectionOrThrow(Direction direction) {
        Direction next = getNextDirection(direction);
        if (next == null) {
            throw new IllegalStateException("Could not get next direction, illegal grid?");
        }
        return next;
    }
}
