package com.babayan.lectures.lecture_10.covid_data;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Integer height;
    private final Integer weight;
    private final String email;

    public Person(String firstName, String lastName, Integer age, Integer height, Integer weight, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName +
                ";\nLastName: " + lastName +
                ";\nAge: " + age +
                ";\nHeight: " + height +
                ";\nWeight: " + weight +
                ";\nEmail: " + email;
    }
}
