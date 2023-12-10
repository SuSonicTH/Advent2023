package com.github.susonicth.advent.advent01;

import com.github.susonicth.advent.Advent;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent0102 extends Advent {
    private static final Pattern FIRST_NUMBER_PATTERN = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|[0-9]).*");
    private static final Pattern SECOND_NUMBER_PATTERN = Pattern.compile(".*(one|two|three|four|five|six|seven|eight|nine|[0-9])");
    private static final Map<String, Integer> NUMBER_MAP = new HashMap<>();

    static {
        NUMBER_MAP.put("one", 1);
        NUMBER_MAP.put("two", 2);
        NUMBER_MAP.put("three", 3);
        NUMBER_MAP.put("four", 4);
        NUMBER_MAP.put("five", 5);
        NUMBER_MAP.put("six", 6);
        NUMBER_MAP.put("seven", 7);
        NUMBER_MAP.put("eight", 8);
        NUMBER_MAP.put("nine", 9);
        NUMBER_MAP.put("0", 0);
        NUMBER_MAP.put("1", 1);
        NUMBER_MAP.put("2", 2);
        NUMBER_MAP.put("3", 3);
        NUMBER_MAP.put("4", 4);
        NUMBER_MAP.put("5", 5);
        NUMBER_MAP.put("6", 6);
        NUMBER_MAP.put("7", 7);
        NUMBER_MAP.put("8", 8);
        NUMBER_MAP.put("9", 9);
    }

    @Override
    protected long mapLineToNumber(String line) {
        Matcher matcher = FIRST_NUMBER_PATTERN.matcher(line);
        matcher.find();
        int first = NUMBER_MAP.get(matcher.group(1));
        int last = first;

        matcher = SECOND_NUMBER_PATTERN.matcher(line);
        if (matcher.find()) {
            last = NUMBER_MAP.get(matcher.group(1));
        }

        return first * 10L + last;
    }
}
