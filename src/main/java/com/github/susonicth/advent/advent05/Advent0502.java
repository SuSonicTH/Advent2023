package com.github.susonicth.advent.advent05;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Advent0502 extends Advent0501 {

    @Override
    public int sumFile(Path file) throws IOException {
        return 0;
    }
    /*
    BAD brute force implementation is really slow
    I'm to lazy todo the proper implementation of geeping seeds as ranges and map (split) them
     */
    @Override
    protected Stream<Long> getSeeds(String line) {
        List<Long> list = super.getSeeds(line).toList();
        List<Range> ranges = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i+=2) {
            ranges.add(new Range(list.get(i), list.get(i + 1)));
        }
        return ranges.stream().flatMap(Range::stream);
    }


    private record Range(long seed, long count) {
        public Stream<Long> stream() {
            return LongStream.range(seed, seed + count - 1).sorted().boxed();
        }
    }
}

