package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static java.lang.Character.isDigit;
import static java.lang.Character.isWhitespace;
import static java.util.Arrays.asList;
import static java.util.stream.LongStream.range;

public class Day06 extends Day {

    static void main() {
        new Day06().run();
    }

    @Override public Object part1() {
        List<String> split = asList(string().split("\n")).reversed();
        String[] sym = split.getFirst().split("\\s+");
        var n = split.stream().skip(1).map(s -> Arrays.stream(s.split("\\s+")).map(Long::parseLong).toList()).toList();

        var transposed = range(0, n.getFirst().size())
            .mapToObj(i -> n.stream().map(r -> r.get((int) i)).toList())
            .toList();
        return range(0, transposed.size())
            .mapToObj(i -> transposed.get((int) i).stream().reduce((a, b) -> sym[(int) i].equals("+") ? a + b : a * b))
            .<Long>mapMulti(Optional::ifPresent)
            .reduce(Long::sum)
            .orElseThrow();
    }

    @Override public Object part2() {
        String[] rows = string().split("\n");
        var sb = new StringBuilder();
        long s = 0;

        for (int col = rows[0].length() - 1; col >= 0; col--) {
            for (String row : rows) {
                char c = row.charAt(col);
                if (!isWhitespace(c) && !isDigit(c)) {
                    BinaryOperator<Long> o = c == '+' ? Long::sum : (l, r) -> l * r;
                    s += Arrays.stream(sb.toString().trim().split("\\s+")).map(Long::parseLong).reduce(o).orElseThrow();
                    sb.setLength(0);
                    break;
                }
                sb.append(c);
            }
        }
        return s;
    }
}
