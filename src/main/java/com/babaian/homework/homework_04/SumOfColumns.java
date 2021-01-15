package com.babaian.homework.homework_04;

import java.util.Arrays;

public class SumOfColumns {

    private static void sumOf2Columns(int[] array1, int[] array2) {
        System.out.println(" col_1 | col_2 | sum ");
        for (int i = 0; i < Math.max(array1.length, array2.length); i++) {
            if (i < array2.length && i < array1.length) {
                System.out.println("\t" + array1[i] + " |  " + array2[i] + "   | " + (array1[i] + array2[i]));
            } else if (i < array1.length) {
                System.out.println("\t" + array1[i] + " |  --   | " + array1[i]);
            } else {
                System.out.println("\t-- |  " + array2[i] + "   | " + array2[i]);
            }
        }
    }

    private static void sumOf2Columns2(int[] array1, int[] array2) {
        int[][] result = new int[Math.max(array1.length, array2.length)][3];
        for (int i = 0; i < result.length; i++) {
            if (i < array2.length && i < array1.length) {
                result[i][0] = array1[i];
                result[i][1] = array2[i];
            } else if (i < array1.length) {
                result[i][0] = array1[i];
            } else {
                result[i][1] = array2[i];
            }
            result[i][2] = result[i][0] + result[i][1];
        }
        printArray2Dim(result);
    }

    private static void printArray2Dim(int[][] array) {
        for (int[] numbers : array) {
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static int[] randomIntArray() {
        int length = (int) (Math.random() * (21 - 5) + 5);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (91 - 10) + 10);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array1 = randomIntArray();
        int[] array2 = randomIntArray();
        sumOf2Columns2(array1, array2);
        System.out.println();
        sumOf2Columns(array1, array2);
    }
}
