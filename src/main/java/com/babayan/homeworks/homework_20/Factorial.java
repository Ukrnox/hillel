package com.babayan.homeworks.homework_20;

import java.math.BigInteger;

public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            System.out.println("Only for non-negative integers!");
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static long factorialRec(int n) {
        long result = 1;
        while (n != 1) {
            result *= n;
            n--;
        }
        return result;
    }

    public static String bigIntFactorial(long n) {
        BigInteger result = BigInteger.ONE;
        while (n != 1) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }
        return result.toString();
    }

    /**
     * This method is used to to find the maximum allowable value
     * to find its factorial for long data type.
     *
     * @return int returns the value when the factorial value overflows long type.
     * Max value for long is 21 (2_432_902_008_176_640_000 * 22 > 9_223_372_036_854_775_807)
     */
    public static int findMaxFactorialLongNum() {
        int result = 1;
        long n = 1;
        while (true) {
            n *= result;
            if (n < 0) {
                return result;
            }
            result++;
        }
    }

    /**
     * This method is used to to find the maximum allowable value
     * to find its factorial for int data type.
     *
     * @return int returns the value when the factorial value overflows int type.
     * Max value for int is 12 (479_001_600 * 13 > 2_147_483_647)
     */
    public static int findMaxFactorialIntNum() {
        int result = 1;
        long n = 1;
        while (true) {
            n *= result;
            if (n * result > Integer.MAX_VALUE) {
                return result;
            }
            result++;
        }
    }
}
