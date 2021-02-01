package com.babayan.homework.homework_04;

import java.util.Locale;

public class IsPalindrome {

    private static boolean isPalindrome(String line) {
        int left = 0;
        int right = line.length() - 1;
        line = line.toUpperCase(Locale.ROOT);
        while (left < right) {
            if (line.charAt(left) != line.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome2(String line) {
        line = line.toUpperCase(Locale.ROOT);
        if (line.length() % 2 == 0) {
            return line.substring(0, line.length() / 2).equals(revertWordSB(line.substring(line.length() / 2)));
        }
        return line.substring(0, line.length() / 2).equals(revertWordSB(line.substring(line.length() / 2 + 1)));
    }

    public static String revertWordSB(String word) {
        StringBuilder result = new StringBuilder(word);
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String line = "Allla";
        System.out.println(isPalindrome(line));
        System.out.println(isPalindrome2(line));
    }
}
