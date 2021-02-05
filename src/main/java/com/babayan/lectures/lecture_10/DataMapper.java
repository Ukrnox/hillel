package com.babayan.lectures.lecture_10;

import java.util.HashMap;

public class DataMapper {
    private final HashMap<Integer, Person> personData;
    private static int id = 1;

    public DataMapper() {
        personData = new HashMap<>();
    }

    public void add(String firstName, String lastName, java.lang.Integer age, Integer height, Integer weight, String email) {
        Person person = new Person(firstName, lastName, age, height, weight, email);
        personData.put(id++, person);
    }

    public HashMap<Integer, Person> getPersonData() {
        return personData;
    }
}
