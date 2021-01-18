package com.babaian.homework.homework_04;

public class IsStrongNum {
    private static boolean isStrongNum(int num) {
        return num == factorialsSum(num);
    }

    private static int factorialsSum(int num) {
        int result = 0;
        while (num > 0) {
            result += factorial(num % 10);
            num /= 10;
        }
        return result;
    }

    private static int factorial(int num) {
        if (num == 1) {
            return 1;
        }else if (num==0){
            return 0;
        }
        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(isStrongNum(145));
    }
}
