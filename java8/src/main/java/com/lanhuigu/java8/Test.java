package com.lanhuigu.java8;

public class Test {
    public static Double[] spitPoint(String orderPoint) {
        String[] orderStartPoints = orderPoint.split(",");
        if (orderStartPoints == null || orderStartPoints.length != 2) {
            return null;
        }
        Double[] points = new Double[2];
        points[0] = Double.valueOf(orderStartPoints[0]);
        points[1] = Double.valueOf(orderStartPoints[1]);

        return points;
    }

    public static void main(String[] args) {
        spitPoint("116.508538,39.793305;116.508538140191,39.79330457899306");
    }
}
