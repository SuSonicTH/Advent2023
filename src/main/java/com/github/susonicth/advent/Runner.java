package com.github.susonicth.advent;

import java.io.IOException;
import java.nio.file.Path;

public class Runner {
    private static final Path INPUT_PATH = Path.of("./input");

    public static void main(String[] args) throws Exception {
        new Runner().run();
    }

    private void run() throws Exception {
        for (int day = 1; day < 24; day++) {
            for (int task = 1; task <= 2; task++) {
                Class<Advent> clazz = getClass(day, task);
                if (clazz == null) {
                    return;
                }
                runTask(clazz.getDeclaredConstructor().newInstance(), day, task);
            }
        }
    }

    private void runTask(Advent advent, int day, int task) throws IOException {
        Path inputFile = INPUT_PATH.resolve(String.format("input%02d.txt", day));
        int code = advent.sumFile(inputFile);
        System.out.println("Day " + day + " " + task + ": " + code);
    }

    private Class<Advent> getClass(int day, int task) {
        String className = String.format("com.github.susonicth.advent.advent%02d.Advent%02d%02d", day, day, task);
        try {
            return (Class<Advent>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
