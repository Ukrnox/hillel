package com.babayan.homework.homework_02;

public class Task_01 {

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
    public static void main(String[] args) {
        System.out.println(customLog(2,8));
    }

}
