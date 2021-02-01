package com.babayan.homeworks.homework_03;

public class Practice_04 {

    private static String describeAge(int age) {
        return "You're a(n) " + ((age <= 12) ? "kid."
                : (age <= 17) ? "teenager."
                : (age <= 64) ? "adult."
                : "elderly.");
    }

    public static void main(String[] args) { System.out.println(describeAge(13)); }

}
