package com.babayan.homeworks.homework_14;

public class DataMapper {
    public static Person apply(String s) {
        try {
            String[] line = s.split(",");
            return new Person(line[0], line[1],
                    Integer.valueOf(line[2]),
                    Integer.valueOf(line[3]),
                    Integer.valueOf(line[4]),
                    line[5]);
        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }
}
