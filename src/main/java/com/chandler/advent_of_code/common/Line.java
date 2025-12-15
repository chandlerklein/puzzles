package com.chandler.advent_of_code.common;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Line<T extends Number> {
    private final Point3d<T> a;
    private final Point3d<T> b;
    private final double distance;

    private Line(Point3d<T> a, Point3d<T> b, double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public static <T extends Number> Line<T> of(Point3d<T> a, Point3d<T> b) {
        return new Line<>(a, b, distance(a, b));
    }

    private static <T extends Number> double distance(Point3d<T> a, Point3d<T> b) {
        return sqrt(
            pow(a.x().doubleValue() - b.x().doubleValue(), 2) +
                pow(a.y().doubleValue() - b.y().doubleValue(), 2) +
                pow(a.z().doubleValue() - b.z().doubleValue(), 2));
    }

    public Point3d<T> a() {
        return a;
    }

    public Point3d<T> b() {
        return b;
    }

    public double distance() {
        return distance;
    }
}
