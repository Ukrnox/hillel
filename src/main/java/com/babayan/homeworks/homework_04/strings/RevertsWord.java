package com.babayan.homeworks.homework_04.strings;

public class RevertsWord {
    public static String revertWordSB(String word) {
        StringBuilder result = new StringBuilder(word);
        result.reverse();
        return result.toString();
    }

    private static String revertWordCA(String word) {
        char[] array = word.toCharArray();
        int left = 0;
        char temp;
        int right = array.length - 1;
        while (left < right) {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        System.out.println(revertWordSB("Hello!"));
    }
}
