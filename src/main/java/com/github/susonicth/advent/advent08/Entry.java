package com.github.susonicth.advent.advent08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entry {
    private static final Pattern PATTERN = Pattern.compile("(.+) = \\((.+), (.+)\\)");
    public final String id;
    public final String[] directions;

    public Entry(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalStateException("Could not match line '" + line + "'");
        }
        id = matcher.group(1);
        directions = new String[]{matcher.group(2), matcher.group(3)};
    }
}
