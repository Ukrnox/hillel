package com.babayan.homeworks.homework_15;

public class DataMapper implements Mapper {
    @Override
    public Person apply(String s) {
        try {
            String[] line = s.split(",");
            return new Person.PersonBuilder()
                    .firstName(line[0])
                    .lastName(line[1])
                    .age(Integer.valueOf(line[2]))
                    .height(Integer.valueOf(line[3]))
                    .weight(Integer.valueOf(line[4]))
                    .email(line[5])
                    .build();
        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }
}
