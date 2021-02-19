package com.babayan.homeworks.homework_13;


import java.util.Arrays;

public class Stat<T extends Number> {

    private final T[] data;

    public Stat(T[] data) {
        this.data = data;
    }

    public void printData() {
        System.out.println(Arrays.toString(data));
    }

    public double average() {
        double temp = 0.0;
        for (T value : data) {
            temp += value.doubleValue();
        }
        return temp / data.length;
    }

    public boolean isSameAverage(Stat<?> stat) {
        return this.average() == stat.average();
    }

}
