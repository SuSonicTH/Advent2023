package advent02;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Round {
    private static final Pattern ROUND_PATTERN = Pattern.compile(" *(\\d+) +([^,]+)(,|$)");
    private static final Comparator<Round> COMPARATOR = Comparator
            .comparing(Round::getRed)
            .thenComparing(Round::getGreen)
            .thenComparing(Round::getBlue);

    private int red = 0;
    private int green = 0;
    private int blue = 0;

    public Round(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Round(String round) {
        Matcher matcher = ROUND_PATTERN.matcher(round);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            switch (matcher.group(2)) {
                case "red":
                    red = number;
                    break;
                case "green":
                    green = number;
                    break;
                case "blue":
                    blue = number;
                    break;
                default:
                    throw new IllegalStateException("Unexpected color: '" + matcher.group(2) + "'");
            }
        }
    }

    @Override
    public String toString() {
        return "Round{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isMoreThen(Round maximum) {
        return red > maximum.red || green > maximum.green || blue > maximum.blue;
    }

    public int power() {
        return red * green * blue;
    }
}
