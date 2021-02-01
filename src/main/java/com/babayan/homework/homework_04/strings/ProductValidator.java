package com.babayan.homework.homework_04.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidator {
    private static final String regex = "^[A-Z]{2}[0-9]{1}[A-Z]{3}[0-9]{2}[A-Z]{2}[0-9]{1}[A-Z]{2}[0-9]{1}[A-Z]{3}[0-9]{1}[A-Z]{2} [0-9]{6}$";

    private static final Pattern pattern = Pattern.compile(regex);

    private static boolean productValidator(String line) {
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            System.out.println("Not a product code!");
            return false;
        }
        String[] a = line.split(" ");
        boolean test1 = Integer.parseInt(findDigitsInString(a[1])) == findMultiplicationResult(findDigitsInString(a[0]));
        return (test1 && matcher.matches());
    }

    //в втором варианте уместил все в return без дополнительной перемнной и вывода сообщения ("Not a product code!");
    private static boolean productValidator2(String line) {
        String[] a = line.split(" ");
        return pattern.matcher(line).matches() && Integer.parseInt(findDigitsInString(a[1])) == findMultiplicationResult(findDigitsInString(a[0]));
    }

    public static String findDigitsInString(String line) {
        return line.replaceAll("\\D+", "");
    }

    public static int findMultiplicationResult(String line) {
        int result = 1;
        String[] array = line.split("(?<=\\G.{2})");
        for (String s : array) {
            result *= Integer.parseInt(s);
        }
        return result;
    }

    public static void main(String[] args) {
        String line = "AX6BYU56UX6CV6BNT7NM 287430";
        System.out.println(productValidator(line));
    }


}
