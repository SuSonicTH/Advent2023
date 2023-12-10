package com.github.susonicth.advent.advent09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class History {
    List<List<Long>> input = new ArrayList<>();


    public History(String line) {
        input.add(Arrays.stream(line.split(" ")).map(Long::parseLong).toList());
    }

    public long getNext() {
        findZeroPoint();
        return calculate((list, num) -> num + list.get(list.size() - 1));
    }

    public long getPrevious() {
        findZeroPoint();
        return calculate((list, num) -> list.get(0) - num);
    }

    private long calculate(Calculation func) {
        long num = 0;
        for (int level = input.size() - 2; level >= 0; level--) {
            num = func.calculate(input.get(level), num);
        }
        return num;
    }

    private void findZeroPoint() {
        List<Long> list = input.get(0);
        while (notAllAreZero(list)) {
            List<Long> next = new ArrayList<>();
            input.add(next);
            for (int i = 1; i < list.size(); i++) {
                next.add(list.get(i) - list.get(i - 1));
            }
            list = next;
        }
    }

    private boolean notAllAreZero(List<Long> list) {
        return list.stream().anyMatch(i -> i != 0);
    }

    private interface Calculation {
        Long calculate(List<Long> list, Long number);
    }

}
