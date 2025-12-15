package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet;

import java.util.Arrays;

import static java.lang.Long.parseLong;

public class Day05 extends Day {
    void main() {
        new Day05().run();
    }

    @Override public Object part1() {
        String[] split = string().split("\n\n");

        var ranges = Arrays
            .stream(split[0].split("\n"))
            .map(str -> str.split("-"))
            .map(arr -> Range.closed(parseLong(arr[0]), parseLong(arr[1])))
            .toList();

        return Arrays
            .stream(split[1].split("\n"))
            .filter(str -> ranges.stream().anyMatch(range -> range.contains(parseLong(str))))
            .count();
    }

    @Override public Object part2() {
        return Arrays
            .stream(string().split("\n\n")[0].split("\n"))
            .map(str -> str.split("-"))
            .map(arr -> Range.closed(parseLong(arr[0]), parseLong(arr[1])))
            .collect(TreeRangeSet::<Long>create, TreeRangeSet::add, TreeRangeSet::addAll)
            .asRanges()
            .stream()
            .mapToLong(r -> r.upperEndpoint() - r.lowerEndpoint() + 1)
            .sum();
    }
}
