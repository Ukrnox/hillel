package com.babayan.homeworks.homework_04;

import java.util.Arrays;

public class MinNumInArray {

    private static int minNumInArray(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    private static int minNumInArrayWithSort(int[] array) {
        Arrays.sort(array);
        return array[0];
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 1, 0, 8, 7};
        System.out.println(minNumInArray(a));
    }
}
