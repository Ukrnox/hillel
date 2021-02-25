package com.babayan.homeworks.homework_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovidStat {

    private final List<Person> data;

    public CovidStat(List<Person> data) {
        this.data = data.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<Person> getData() {
        return new ArrayList<>(data);
    }

    private String mostPopularWord(Stream<String> stream) {
        return stream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

    public String getMostPopularName() {
        return mostPopularWord(data.stream()
                .map(Person::getFirstName));
    }


    public String getMostPopularSurname() {
        return mostPopularWord(data.stream()
                .map(Person::getLastName));
    }

    public String getMostPopularMailDomain() {
        return mostPopularWord(data.stream()
                .map(Person::getEmail)
                .flatMap(Pattern.compile("(?=@)")::splitAsStream)
                .filter(w -> w.contains("@")));
    }

    private int averageNum(Stream<Integer> stream) {
        return stream.reduce(0, Integer::sum) / data.size();
    }

    public int getAverageAge() {
        return averageNum(data.stream()
                .map(Person::getAge));
    }

    public int getAverageHeight() {
        return averageNum(data.stream()
                .map(Person::getHeight));
    }

    public int getAverageWeight() {
        return averageNum(data.stream()
                .map(Person::getWeight));
    }
}
