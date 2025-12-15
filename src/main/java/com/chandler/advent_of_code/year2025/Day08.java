package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;
import org.jgrapht.alg.util.UnionFind;

import java.util.HashSet;
import java.util.List;

import static java.lang.Long.parseLong;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.IntStream.range;

public class Day08 extends Day {
    void main() {
        new Day08().run();
    }

    @Override public Object part1() {
        var points = stream().map(line -> line.split(",")).map(Point3d::of).toList();
        var lines = getLines(points);
        var uf = new UnionFind<>(new HashSet<>(points));

        range(0, 1_000).mapToObj(lines::get).forEach(line -> uf.union(line.a, line.b));

        return points
            .stream().collect(groupingBy(uf::find))
            .values().stream().map(List::size)
            .sorted(reverseOrder())
            .limit(3)
            .reduce((a, b) -> a * b).orElseThrow();
    }

    @Override public Object part2() {
        var points = stream().map(line -> line.split(",")).map(Point3d::of).toList();
        var lines = getLines(points);
        var uf = new UnionFind<>(new HashSet<>(points));
        for (var line : lines) {
            uf.union(line.a, line.b);
            if (uf.numberOfSets() == 1) return line.a.x * line.b.x;
        }
        throw new IllegalStateException();
    }

    private List<Line> getLines(List<Point3d> points) {
        return range(0, points.size())
            .boxed().flatMap(i -> range(i + 1, points.size()).mapToObj(j -> Line.of(points.get(i), points.get(j))))
            .sorted(comparing(Line::distance)).toList();
    }

    private record Line(Point3d a, Point3d b, double distance) {
        private static Line of(Point3d a, Point3d b) {
            return new Line(a, b, Line.distance(a, b));
        }

        private static double distance(Point3d a, Point3d b) {
            return sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2) + pow(a.z - b.z, 2));
        }
    }

    private record Point3d(long x, long y, long z) {
        private static Point3d of(String[] split) {
            if (split.length != 3) throw new IllegalArgumentException();
            return new Point3d(parseLong(split[0]), parseLong(split[1]), parseLong(split[2]));
        }
    }

}
