package com.github.susonicth.advent.advent02;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private static final Pattern GAME_PATTERN = Pattern.compile("^Game (\\d+):(.*)$");
    private static final Pattern ROUND_PATTERN = Pattern.compile("([^;]+)(;|$)");
    private static final Round MAXIMUM = new Round(12, 13, 14);

    private final int id;
    private final List<Round> rounds = new ArrayList<>();

    public Game(String line) {
        Matcher gameMatcher = matchLineOrThrow(line);
        id = Integer.parseInt(gameMatcher.group(1));
        parseRounds(gameMatcher.group(2));
    }

    private static Matcher matchLineOrThrow(String line) {
        Matcher gameMatcher = GAME_PATTERN.matcher(line);
        if (!gameMatcher.matches()) {
            throw new IllegalStateException("Could not parse game id from input '" + line + "'");
        }
        return gameMatcher;
    }

    private void parseRounds(String input) {
        Matcher roundMatcher = ROUND_PATTERN.matcher(input);
        while (roundMatcher.find()) {
            rounds.add(new Round(roundMatcher.group(1)));
        }
    }

    public boolean isPossible() {
        return rounds.stream().filter(round -> round.isMoreThen(MAXIMUM)).findAny().isEmpty();
    }

    public int getId() {
        return id;
    }

    public Round getMinimum() {
        return rounds.stream().reduce(new Round(0, 0, 0), Round::max);
    }
}
