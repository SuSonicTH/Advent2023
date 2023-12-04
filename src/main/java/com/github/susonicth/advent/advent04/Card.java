package com.github.susonicth.advent.advent04;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Card {
    final Set<Integer> winning;
    final Set<Integer> numbers;
    private int copies = 1;

    public Card(String line) {
        String[] card = line.split(": ")[1].split(" \\| ");
        winning = getNumbers(card[0]);
        numbers = getNumbers(card[1]);
    }

    private Set<Integer> getNumbers(String list) {
        return Arrays.stream(list.split(" "))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public int getScore() {
        return 1 << getMatchingNumbers() >> 1;
    }

    public int getMatchingNumbers() {
        return (int) numbers.stream().filter(winning::contains).count();
    }

    public void copy(int count) {
        copies += count;
    }

    public int getCopies() {
        return copies;
    }
}