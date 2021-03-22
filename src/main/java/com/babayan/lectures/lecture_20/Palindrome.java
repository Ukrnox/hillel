package com.babayan.lectures.lecture_20;

import java.util.Locale;

public class Palindrome {
    public static boolean isPalindrome(String line) {
        line = line.replaceAll("[^A-Za-z]+", "").toUpperCase(Locale.ROOT);
        int length = line.length();
        System.out.println(line.substring(0, length / 2));
        System.out.println(new StringBuilder(line.substring(length / 2 + 1, length)).reverse().toString());
        if (line.length() % 2 == 0) {
            return line.substring(0, length / 2).equals
                    (new StringBuilder(line.substring(length / 2, length)).reverse().toString());
        } else return line.substring(0, length / 2).equals
                (new StringBuilder(line.substring(length / 2 + 1, length)).reverse().toString());
    }

    public static boolean isPalindrome2(String line) {
        line = line.replaceAll("[^A-Za-z]", "").toUpperCase(Locale.ROOT);
        int left = 0;
        int right = line.length() - 1;
        while (left < right) {
            if (line.charAt(left) != line.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println(isPalindrome2("aa allla aa"));
        long l3 = System.currentTimeMillis();
        System.out.println(l3 - l2);
    }
}
