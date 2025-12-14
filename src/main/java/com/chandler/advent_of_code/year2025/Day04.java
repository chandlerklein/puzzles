package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;

import java.util.Arrays;

public class Day04 extends Day {

    private static final int[][] DIRECTIONS = new int[][]{
        { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 } };

    static void main() {
        new Day04().run();
    }

    @Override public Object part1() {
        int[][] arr = Arrays
            .stream(string().split("\n"))
            .map(str -> str.chars().map(c -> c == '@' ? 1 : 0).toArray())
            .toArray(int[][]::new);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 1) continue;
                int adjacentRolls = 0;
                for (var direction : DIRECTIONS) {
                    try {
                        if (arr[i + direction[0]][j + direction[1]] == 1) adjacentRolls++;
                    } catch (Exception _) { /* ignore, no roll */ }
                }
                if (adjacentRolls < 4) count++;
            }
        }
        return count;
    }

    @Override public Object part2() {
        int[][] arr = Arrays
            .stream(string().split("\n"))
            .map(str -> str.chars().map(c -> c == '@' ? 1 : 0).toArray())
            .toArray(int[][]::new);
        int total = 0;
        int rollsRemoved;
        do {
            rollsRemoved = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 1) continue;
                    int adjacentRolls = 0;
                    for (var direction : DIRECTIONS) {
                        try {
                            if (arr[i + direction[0]][j + direction[1]] == 1) adjacentRolls++;
                        } catch (Exception _) { /* ignore, no roll */ }
                    }
                    if (adjacentRolls < 4) {
                        arr[i][j] = 0;
                        rollsRemoved++;
                    }
                }
            }
            total += rollsRemoved;
        } while (rollsRemoved != 0);
        return total;
    }

}
