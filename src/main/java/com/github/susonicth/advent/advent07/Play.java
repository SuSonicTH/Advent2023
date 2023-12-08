package com.github.susonicth.advent.advent07;

class Play implements Comparable<Play> {
    private static final String ORDER = "23456789TJQKA";
    private static final String ORDER_WITH_JOKER = "J23456789TQKA";

    public final String cards;
    public final int bid;
    public final Hand hand;
    private final String order;

    Play(String line, boolean withJoker) {
        order = withJoker ? ORDER_WITH_JOKER : ORDER;

        String[] part = line.split(" ");
        cards = part[0];
        bid = Integer.parseInt(part[1]);

        if (withJoker) {
            hand = Hand.getHandWithJoker(cards);
        } else {
            hand = Hand.getHand(cards);
        }
    }

    @Override
    public int compareTo(Play other) {
        int ret = hand.compareTo(other.hand);
        int i = 0;
        while (ret == 0 && i < 5) {
            ret = order.indexOf(cards.charAt(i)) - order.indexOf(other.cards.charAt(i));
            i++;
        }
        return ret;
    }

}
