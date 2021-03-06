package com.babayan.homeworks.homework_17;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Data
    private class Geo {
        private String lat;
        private String lng;
    }
}

