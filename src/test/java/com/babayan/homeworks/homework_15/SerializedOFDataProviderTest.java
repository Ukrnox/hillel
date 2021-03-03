package com.babayan.homeworks.homework_15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SerializedOFDataProviderTest {

    @Test
    void provide() {
        Person person = new Person("Volodymyr", "Zelensky", 42, 165, 78, "zelensky@ukr.com");
        List<Person> personListResult = List.of(person);
        DataProvider data = new SerializedOFDataProvider();
        Assertions.assertEquals(data.provide("TestPerson.out"), personListResult);
    }
}