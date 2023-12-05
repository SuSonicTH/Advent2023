#!/bin/bash

if [ $# -ne 1 ]; then
    echo "usage: mkday.sh [day]"
    exit 1
fi

day=$1

mainDir="src/main/java/com/github/susonicth/advent/advent$day/"
testDir="src/test/java/com/github/susonicth/advent/advent$day/"

mainFile="
package com.github.susonicth.advent.advent${day};

import com.github.susonicth.advent.Advent;

public class Advent${day}01 extends Advent {

    @Override
    protected int mapLineToNumber(String line) {
        return 0;
    }
}
"

testFile="package com.github.susonicth.advent.advent${day};

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Advent${day}01Test {
    public static final Path SAMPLE_FILE = Path.of(\"./input/sample${day}01.txt\");

    @Test
    void sampleFileSummedUpCorrectly() throws IOException {
        assertEquals(0, new Advent${day}01().sumFile(SAMPLE_FILE));
    }
}
"

mkdir $mainDir
echo "$mainFile" > $mainDir/Advent${day}01.java
cat $mainDir/Advent${day}01.java | sed -e "s/${day}01/${day}02/" > $mainDir/Advent${day}02.java

mkdir $testDir
echo "$testFile" > $testDir/Advent${day}01Test.java
cat $testDir/Advent${day}01Test.java | sed -e "s/${day}01/${day}02/" > $testDir/Advent${day}02Test.java
