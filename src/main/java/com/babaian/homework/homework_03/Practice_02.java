package com.babaian.homework.homework_03;

import java.util.Scanner;

public class Practice_02 {

    public static String bmi(double m, double h) {
        double bmi = m / Math.pow(h, 2);
        bmi = (double) ((int) (bmi * 10)) / 10;
        System.out.println("Your bmi : " + bmi + " kg/m2");
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi <= 25.0) {
            return "Normal";
        } else if (bmi <= 30.0) {
            return "Overweight";
        }
        return "Obese";
//        return ((bmi <= 18.5)?"Underweight"
//                :(bmi <= 25.0)?"Normal"
//                :(bmi <= 30.0)?"Overweight"
//                :"Obese");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight in kilograms: ");
        double m = input.nextDouble();
        System.out.println("Enter your height in meters(ex: 1,7): ");
        double h = input.nextDouble();
        System.out.println(bmi(m, h));
    }

}
