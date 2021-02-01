package com.babayan.homework.homework_04.strings;

public class StringUtils {
    private static String randomString(String type, int length) {
        StringBuilder line = new StringBuilder(length);
        switch (type) {
            case "alpha":
                for (int i = 0; i < length; i++) {
                    line.append(randomCharAtoZ());
                }
                break;
            case "numeric":
                for (int i = 0; i < length; i++) {
                    line.append(randomChar0to9());
                }
                break;
            case "alphanumeric":
                for (int i = 0; i < length; i++) {
                    int random = (int) (Math.random() * 2 + 1);
                    if (random == 1) {
                        line.append(randomChar0to9());
                    } else {
                        line.append(randomCharAtoZ());
                    }
                }
                break;
            default:
                return "Wrong type!";
        }
        return line.toString();
    }

    private static char randomCharAtoZ() {
        int temp = (int) (Math.random() * (('z' - 'a') + 1) + 'a');
        return (char) temp;
    }

    private static char randomChar0to9() {
        int temp = (int) (Math.random() * (('9' - '0') + 1) + '0');
        return (char) temp;
    }

    public static void main(String[] args) {
        System.out.println(randomString("alphanumeric", 4));
    }
}
