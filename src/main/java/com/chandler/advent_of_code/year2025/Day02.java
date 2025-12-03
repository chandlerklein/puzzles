package com.chandler.advent_of_code.year2025;

import com.chandler.advent_of_code.common.Day;

import static java.lang.Long.parseLong;
import static java.lang.Math.floorDivExact;
import static java.util.stream.Gatherers.windowFixed;

public class Day02 extends Day {
    public static void main(String[] args) {
        new Day02().run();
    }

    @Override public Object part1() {
        long sum = 0;
        for (String s : string().split(",")) {
            var ids = s.trim().split("-");
            if (ids.length != 2) throw new IllegalStateException();
            long id1 = parseLong(ids[0]);
            long id2 = parseLong(ids[1]);
            for (long i = id1; i <= id2; i++) {
                var str = Long.toString(i);
                if (str.length() % 2 != 0) continue;
                var substr1 = str.substring(0, str.length() / 2);
                var substr2 = str.substring(str.length() / 2);
                if (substr1.equals(substr2)) sum += i;
            }
        }
        return sum;
    }

    @Override public Object part2() {
        long sum = 0;
        for (String s : string().split(",")) {
            var ids = s.trim().split("-");
            if (ids.length != 2) throw new IllegalStateException();
            long id1 = parseLong(ids[0]);
            long id2 = parseLong(ids[1]);
            for (long i = id1; i <= id2; i++) {
                var str = Long.toString(i);
                for (int j = 1; j <= floorDivExact(str.length(), 2); j++) {
                    var isRepeated = str
                        .chars()
                        .mapToObj(c -> (char) c)
                        .gather(windowFixed(j))
                        .distinct()
                        .count() == 1;
                    if (!isRepeated) continue;
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
}
