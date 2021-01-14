package com.babaian.homework.homework_03;

public class Practice_03 {

    private static int centuryFromYear(int year) {
        return (int) (Math.ceil(year / 100.00));
    }

    public static void main(String[] args) {
        System.out.println(centuryFromYear(1601));
    }

}
