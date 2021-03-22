package com.babayan.lectures.lecture_20;

public class Timer {

    private static long start;
    private static long end;

    public static void start() {
        start = System.currentTimeMillis();
    }

    public static void stop() {
        end = System.currentTimeMillis();
    }

    public static void printResult() {
        System.out.println(end - start);
    }
}
