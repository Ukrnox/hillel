package com.babayan.homeworks.homework_15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataFactoryCreatorTest {

    @Test
    void createData() {
        DataFactory factory = new DataFactoryCreator("Asaa.csv");
        Assertions.assertEquals(factory.createData().getClass(), CsvFileDataProvider.class);
        factory = new DataFactoryCreator("Asaa.txt");
        Assertions.assertEquals(factory.createData().getClass(), SerializedOFDataProvider.class);
    }
}