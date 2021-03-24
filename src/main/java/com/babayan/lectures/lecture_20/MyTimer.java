package com.babayan.lectures.lecture_20;

public class MyTimer {

    private long start;

    public void start() {
        start = System.nanoTime();
    }

    public void printResult() {
        long end = System.nanoTime();
        System.out.println(end - start + " ns");
        start = 0;
    }
}
