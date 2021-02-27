package com.babayan.homeworks.homework_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CovidStatTest {
    private List<Person> persons;
    private CovidStat covid;

    @BeforeEach
    void setUp() {
        Person a = new Person.PersonBuilder()
                .firstName("Eugene").lastName("Tyson").age(32).height(170).weight(81).email("berezhnoy87@gmail.com").build();
        Person b = new Person.PersonBuilder()
                .firstName("Mike").lastName("Tyson").age(54).height(178).weight(81).email("iron.mike@gmail.com").build();
        Person c = new Person.PersonBuilder()
                .firstName("Mike").lastName("Naumenko").age(36).height(150).weight(70).email("iron.mike@gmail.com").build();
        Person d = new Person("Volodymyr", "Zelensky", 42, 165, 78, "zelensky@ukr.com");
        persons = List.of(a, b, c, d);
        covid = new CovidStat(persons);
    }

    @Test
    void getMostPopularName() {
        assertEquals(covid.getMostPopularName(), "Mike");
    }

    @Test
    void getMostPopularSurname() {
        assertEquals(covid.getMostPopularSurname(), "Tyson");
    }

    @Test
    void getMostPopularMailDomain() {
        assertEquals(covid.getMostPopularMailDomain(), "@gmail.com");
    }

    @Test
    void getAverageAge() {
        assertEquals(covid.getAverageAge(), 41);
    }

    @Test
    void getAverageHeight() {
        assertEquals(covid.getAverageHeight(), 165);
    }

    @Test
    void getAverageWeight() {
        assertEquals(covid.getAverageWeight(), 77);
    }
}