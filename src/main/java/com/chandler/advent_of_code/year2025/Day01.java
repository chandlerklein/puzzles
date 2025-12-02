package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Day01 extends Day {

    public static void main(String[] args) {
        new Day01().run();
    }

    @Override public Object part1() {
        var number = new AtomicInteger(50);
        var zeroCount = new AtomicInteger();
        stream().forEach(instruction -> {
            char direction = instruction.charAt(0);
            int rotations = parseInt(instruction.substring(1)) * (direction == 'L' ? -1 : 1);
            number.set((number.get() + rotations) % 100);
            if (number.get() == 0) zeroCount.incrementAndGet();
        });
        return zeroCount;
    }

    @Override public Object part2() {
        var number = new AtomicInteger(50);
        var zeroCount = new AtomicInteger();
        stream().forEach(instruction -> {
            char direction = instruction.charAt(0);
            int rotations = parseInt(instruction.substring(1)) * (direction == 'L' ? -1 : 1);
            for (int i = 0; i < abs(rotations); i++) {
                number.set((number.get() + (direction == 'L' ? -1 : 1)) % 100);
                if (number.get() == 0) {
                    zeroCount.incrementAndGet();
                }
            }
        });
        return zeroCount;
    }

}
