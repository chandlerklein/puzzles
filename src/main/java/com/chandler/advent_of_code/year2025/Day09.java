package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;
import com.chandler.advent_of_code.util.Rectangle;

import java.awt.geom.Point2D;

import static java.lang.Double.parseDouble;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.IntStream.range;

public class Day09 extends Day {
    void main() {
        new Day09().run();
    }

    @Override public Object part1() {
        var points = stream()
            .map(str -> str.split(","))
            .map(split -> new Point2D.Double(parseDouble(split[0]), parseDouble(split[1])))
            .toList();
        return range(0, points.size())
            .boxed()
            .flatMap(i -> range(i + 1, points.size()).mapToObj(j -> Rectangle.area(points.get(i), points.get(j))))
            .map(Double::longValue)
            .max(naturalOrder())
            .orElseThrow();
    }

    @Override public Object part2() {
        return null;
    }
}
