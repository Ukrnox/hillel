package com.babayan.homeworks.homework_20;

import java.math.BigInteger;

public class Fibonacci {

    static long count = 0;

    /**
     * This method has exponential execution time.
     * Recursive call is made for all numbers below n.
     * It took 5_942_430_145 recursive method calls to calculate 46 Fibonacci number (the maximum allowable value
     * for int before overflow).
     */
    public static int fibonacciRec(int n) {
        count++;
        if (n < 2) {
            return n;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    /**
     * The performance of algorithm O(n).
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            return (int) Pow.pow(-1, -n + 1) * fibonacci(-n);
        }
        int a = 0;
        int result = 1;
        while (n >= 0) {
            a += result;
            result = a - result;
            n--;
        }
        return result;
    }

    public static int maxFibonacci() {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger result = BigInteger.ONE;
        int n = 0;
        while (true) {
            if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                System.out.println(result.toString());
                return n - 2;
            }
            a = a.add(result);
            result = a.subtract(result);
            n++;
        }
    }
}
