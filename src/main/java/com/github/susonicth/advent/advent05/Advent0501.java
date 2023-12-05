
package com.github.susonicth.advent.advent05;

import com.github.susonicth.advent.Advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Advent0501 extends Advent {

    private RangeMap seedToSoil;
    private RangeMap soilTofertilizer;
    private RangeMap fertilizerTowater;
    private RangeMap waterTolight;
    private RangeMap lightTotemperature;
    private RangeMap temperatureTohumidity;
    private RangeMap humidityTolocation;

    @Override
    public int sumFile(Path file) throws IOException {
        return (int)loadFile(file).stream().mapToLong(this::getLocation).min().orElseThrow();
    }

    List<Long> loadFile(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        List<Long> seeds = getSeeds(lines.get(0));
        seedToSoil = new RangeMap(lines, "seed-to-soil");
        soilTofertilizer =  new RangeMap(lines, "soil-to-fertilizer");
        fertilizerTowater =  new RangeMap(lines, "fertilizer-to-water");
        waterTolight =  new RangeMap(lines, "water-to-light");
        lightTotemperature =  new RangeMap(lines, "light-to-temperature");
        temperatureTohumidity =  new RangeMap(lines, "temperature-to-humidity");
        humidityTolocation =  new RangeMap(lines, "humidity-to-location");
        return seeds;
    }

    long getLocation(long seed) {
        return humidityTolocation.get(temperatureTohumidity.get(lightTotemperature.get(waterTolight.get(fertilizerTowater.get(soilTofertilizer.get(seedToSoil.get(seed)))))));
    }

    private List<Long> getSeeds(String line) {
        return Arrays.stream(line.substring(7).split(" ")).map(Long::parseLong).toList();
    }
}

