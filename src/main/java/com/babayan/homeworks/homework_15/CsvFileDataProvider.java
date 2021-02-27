package com.babayan.homeworks.homework_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileDataProvider implements DataProvider {

    private final Mapper mapToPerson;

    public CsvFileDataProvider(Mapper mapToPerson) {
        this.mapToPerson = mapToPerson;
    }

    @Override
    public List<Person> provide(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream
                    .filter(x -> !x.equals(""))
                    .map(mapToPerson::apply)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
