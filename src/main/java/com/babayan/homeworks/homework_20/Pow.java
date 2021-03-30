package com.babayan.homeworks.homework_20;

public class Pow {
    public static double powRec(double n, double m) {
        if (n < 0) {
            return m % 2 == 0 ? powRec(-n, m) : -powRec(-n, m);
        }
        if (m < 0) {
            return 1 / powRec(n, -m);
        }
        if (m != 0) {
            return (n * powRec(n, m - 1));
        }
        return 1;
    }

    public static double pow(double n, double m) {
        if (n < 0) {
            return m % 2 == 0 ? pow(-n, m) : -pow(-n, m);
        }
        if (m < 0) {
            return 1 / pow(n, -m);
        }
        if (m != 0) {
            double base = n;
            while (m != 1) {
                n = n * base;
                m--;
            }
            return n;
        }
        return 1;
    }
}
