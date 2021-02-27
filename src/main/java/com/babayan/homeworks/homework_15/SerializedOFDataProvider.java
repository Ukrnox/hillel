package com.babayan.homeworks.homework_15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializedOFDataProvider implements DataProvider {
    @Override
    public List<Person> provide(String path) {
        List<Person> listOfPersons = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            while (input.available() != -1) {
                try {
                    listOfPersons.add((Person) input.readObject());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPersons;
    }
}
