package com.github.susonicth.advent.advent05;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Advent0502 extends Advent0501 {

    @Override
    protected Stream<Long> getSeeds(String line) {
        List<Long> list = super.getSeeds(line).toList();
        List<Range> ranges = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i+=2) {
            ranges.add(new Range(list.get(i), list.get(i + 1)));
        }
        return ranges.stream().parallel().flatMap(Range::stream);
    }


    private record Range(long seed, long count) {
        public Stream<Long> stream() {
            return LongStream.range(seed, seed+count).sorted().boxed();
        }
    }
}

