package com.babayan.homeworks.homework_15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvFileDataProviderTest {

    @Test
    void provide() {
        Person person = new Person("Volodymyr", "Zelensky", 42, 165, 78, "zelensky@ukr.com");
        List<Person> personListResult = List.of(person);
        String person1 = "Volodymyr,Zelensky,42,165,78,zelensky@ukr.com";
        DataProvider data = new CsvFileDataProvider(new DataMapper());
        Assertions.assertEquals(data.provide("D:\\Java\\hillel\\src\\main\\resources\\lecture_10\\datatest.csv"), personListResult);
    }
}