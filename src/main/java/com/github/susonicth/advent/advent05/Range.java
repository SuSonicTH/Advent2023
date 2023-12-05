package com.github.susonicth.advent.advent05;

public class Range {
    private final long destination;
    private final long source;
    private final long count;

    public Range(String line) {
        String[] values = line.split(" ");
        destination = Long.parseLong(values[0]);
        source = Long.parseLong(values[1]);
        count = Long.parseLong(values[2]);
    }

    public Long get(long from) {
        if (from >= source && from <= source + count) {
            return destination + from - source;
        }
        return null;
    }
}
