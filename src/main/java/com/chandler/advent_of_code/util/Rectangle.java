package com.chandler.advent_of_code.util;

import java.awt.geom.Point2D;

public class Rectangle {

    public static double area(Point2D a, Point2D b) {
        return (Math.abs(b.getY() - a.getY()) + 1) * (Math.abs(b.getX() - a.getX()) + 1);
    }
}
