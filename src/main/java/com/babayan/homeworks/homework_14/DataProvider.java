package com.babayan.homeworks.homework_14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataProvider {
    static public List<Person> provide(String fileURL) {
        try (Stream<String> stream = Files.lines(Paths.get(fileURL))) {
            return stream
                    .filter(x -> !x.equals(""))
                    .map(DataMapper::apply)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
