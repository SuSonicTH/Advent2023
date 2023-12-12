package com.github.susonicth.advent.advent05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RangeMap {
    private final String name;
    private final List<Range> ranges = new ArrayList<>();

    public RangeMap(List<String> lines, String name) {
        this.name = name;
        readMap(lines, getStartOfMap(lines));
    }

    private int getStartOfMap(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(name)) {
                return i + 1;
            }
        }
        throw new IllegalStateException("Could not find map '" + name + "'");
    }

    private void readMap(List<String> lines, int startOfMap) {
        int i = startOfMap;
        String line;
        while (i < lines.size() && !(line = lines.get(i++)).isEmpty()) {
            ranges.add(new Range(line));
        }
    }

    public long get(long source) {
        return ranges.stream()
                .map(range -> range.get(source))
                .filter(Objects::nonNull)
                .findAny()
                .orElse(source);
    }
}
