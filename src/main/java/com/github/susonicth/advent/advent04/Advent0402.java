package com.github.susonicth.advent.advent04;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Advent0402 extends Advent {

    @Override
    public long sumFile(Path file) throws IOException {
        int cardCount = 0;
        List<Card> cards = Files.readAllLines(file).stream().map(Card::new).toList();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            cardCount += card.getCopies();
            int matches = card.getMatchingNumbers();
            for (int x = 0; x < matches; x++) {
                cards.get((i + x + 1)).copy(card.getCopies());
            }
        }
        return cardCount;
    }

}

