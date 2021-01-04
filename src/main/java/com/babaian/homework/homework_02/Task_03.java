package com.babaian.homework.homework_02;

public class Task_03 {

    public static void sq (double a,double b, double c) {
        double[] result = new double[2];
        result[0] = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
        result[1] = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
        if (result[0] > result[1]) {
            double temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        System.out.println(result[0] + " " + result[1]);
    }
    public static void main(String[] args) {
        sq(1,-1,-2);
    }
}
