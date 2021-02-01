package com.babayan.homeworks.homework_04.strings;

import java.util.regex.Pattern;

public class LIneRedactor {
    public static String lIneRedactor(String line) {
        Pattern patternBelow5 = Pattern.compile("[0-5]");
        Pattern patternAbove5 = Pattern.compile("[5-9]");
        return patternAbove5.matcher(patternBelow5.matcher(line).replaceAll("0")).replaceAll("1");
    }

    public static void main(String[] args) {
        System.out.println(lIneRedactor("55992210AAA"));
    }
}
