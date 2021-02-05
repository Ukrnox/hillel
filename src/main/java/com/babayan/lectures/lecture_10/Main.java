package com.babayan.lectures.lecture_10;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        DataProvider dataProvider = new DataProvider();
        String file = "D:\\Java\\hillel\\src\\main\\resources\\lecture_10\\data.csv";
        dataProvider.provide(file);
//        Person person = dataProvider.getDataMapper().getPersonData().get(2);
//        System.out.println(person);
        CovidStat covidStat = new CovidStat(dataProvider.getDataMapper().getPersonData());
        System.out.println(covidStat.getMostPopularName());
//        System.out.println(Arrays.toString(covidStat.getMostPopularName()));
    }
}
