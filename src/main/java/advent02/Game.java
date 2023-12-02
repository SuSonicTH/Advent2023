package advent02;

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
        Matcher gameMatcher = GAME_PATTERN.matcher(line);
        if (!gameMatcher.matches()) {
            throw new IllegalStateException("Could not parse game id from input '" + line + "'");
        }
        id = Integer.parseInt(gameMatcher.group(1));
        Matcher roundMatcher = ROUND_PATTERN.matcher(gameMatcher.group(2));
        while (roundMatcher.find()) {
            rounds.add(new Round(roundMatcher.group(1)));
        }
    }

    public boolean isPossible() {
        for (Round round : rounds) {
            if (round.isMoreThen(MAXIMUM)) {
                return false;
            }
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public Round getMinimum() {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (Round round : rounds) {
            if (round.getRed() > red) {
                red = round.getRed();
            }
            if (round.getGreen() > green) {
                green = round.getGreen();
            }
            if (round.getBlue() > blue) {
                blue = round.getBlue();
            }
        }
        return new Round(red, green, blue);
    }
}
