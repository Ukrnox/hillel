package com.babayan.homeworks.homework_15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataMapperTest {

    @Test
    void apply() {
        Mapper mapper = new DataMapper();
        String line = "Volodymyr,Zelensky,42,165,78,zelensky@ukr.com";
        Person person = new Person("Volodymyr", "Zelensky", 42, 165, 78, "zelensky@ukr.com");
        Assertions.assertEquals(mapper.apply(line), person);
    }
}