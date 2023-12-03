package com.github.susonicth.advent.advent03;

public enum CharType {
    EMPTY,
    NUMBER,
    GEAR,
    SYMBOL;

    public static CharType getFromChar(Character c) {
        return getFromChar(c, false);
    }

    public static CharType getFromCharWithGear(Character c) {
        return getFromChar(c, true);
    }

    private static CharType getFromChar(Character c, boolean splitOutGear) {
        if (c >= '0' && c <= '9') {
            return CharType.NUMBER;
        } else if (c == '.') {
            return CharType.EMPTY;
        } else if (splitOutGear && c == '*') {
            return CharType.GEAR;
        } else {
            return CharType.SYMBOL;
        }
    }
}
