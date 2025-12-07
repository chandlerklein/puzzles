package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;
import org.jspecify.annotations.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class Day03 extends Day {
    static void main() {
        new Day03().run();
    }

    @Override public Object part1() {
        return stream().mapToInt(this::getMaxJoltagePart1).sum();
    }

    @Override public Object part2() {
        return null;
    }

    private int getMaxJoltagePart1(String bank) {
        int largest = -1;
        var chars = bank.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                largest = Math.max(largest, parseInt("%c%c".formatted(chars[i], chars[j])));
            }
        }
        return largest;
    }

}
