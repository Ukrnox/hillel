package com.babaian.homework.homework_03;

public class Practice_03 {
    public static int centuryFromYear(int year) {
        return (int) (Math.ceil((double) year / 100));
    }

    public static void main(String[] args) {
        System.out.println(centuryFromYear(1600));
    }

}
