package com.babayan.homeworks.homework_20;

import java.util.Locale;

public class Palindrome {
    public static boolean isPalindrome(String line) {
        //removes separators from the string and makes it uppercase
        line = line.replaceAll("[^A-Za-z]+", "").toUpperCase(Locale.ROOT);
        int length = line.length();
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
}
