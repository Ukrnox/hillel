package com.babayan.homework.homework_03;

import java.util.Scanner;

public class Practice_02 {
    private static String bmi(double m, double h) {
        double bmi = m / Math.pow(h, 2);
        System.out.printf("Your bmi : %.1fkg/m2\n", bmi);
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi <= 25.0) {
            return "Normal";
        } else if (bmi <= 30.0) {
            return "Overweight";
        }
        return "Obese";

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
