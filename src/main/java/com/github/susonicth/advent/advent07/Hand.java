package com.github.susonicth.advent.advent07;

import java.util.Arrays;
import java.util.Map;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

enum Hand {
    HIGH_CARD("11111"),
    ONE_PAIR("2111"),
    TWO_PAIR("221"),
    THREE_OF_A_KIND("311"),
    FULL_HOUSE("32"),
    FOUR_OF_A_KIND("41"),
    FIVE_OF_A_KIND("5");

    private static final Integer JOKER = (int) 'J';
    private static final Map<String, Hand> patternToHand = Arrays.stream(values()).collect(toMap(k -> k.pattern, v -> v));
    private final String pattern;

    Hand(String pattern) {
        this.pattern = pattern;
    }

    public static Hand getHand(String cards) {
        return getHandFromCountPerCard(getCountsPerCard(cards));
    }

    private static Map<Integer, Long> getCountsPerCard(String cards) {
        return cards.chars().boxed().collect(groupingBy(k -> k, counting()));
    }

    private static Hand getHandFromCountPerCard(Map<Integer, Long> counts) {
        return patternToHand.get(
                counts.values().stream().sorted(reverseOrder())
                        .map(c -> c + "").collect(joining(""))
        );
    }

    public static Hand getHandWithJoker(String cards) {
        Map<Integer, Long> counts = getCountsPerCard(cards);
        moveJokerCountToHighestCountCard(counts);
        return getHandFromCountPerCard(counts);
    }

    private static void moveJokerCountToHighestCountCard(Map<Integer, Long> counts) {
        if (counts.containsKey(JOKER)) {
            Long jokers = counts.get(JOKER);
            if (jokers < 5) {
                counts.remove(JOKER);
                Map.Entry<Integer, Long> maxEntry = counts.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow(() -> new IllegalStateException("Can't happen"));
                counts.put(maxEntry.getKey(), maxEntry.getValue() + jokers);
            }
        }
    }

}
