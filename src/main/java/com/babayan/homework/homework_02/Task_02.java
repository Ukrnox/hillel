package com.babayan.homework.homework_02;

public class Task_02 {

    public static double heron (double a,double b, double c){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));

    }
    public static void main(String[] args) {
        System.out.println(heron(3,4,5));
    }
}
