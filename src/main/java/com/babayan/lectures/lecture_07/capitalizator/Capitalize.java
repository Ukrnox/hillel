package com.babayan.lectures.lecture_07.capitalizator;

public class Capitalize {

    InputGetter getter;

    public Capitalize(InputGetter getter) {
        this.getter = getter;
    }

    public String getUpperCaseInput(){
        String s = getter.get();
        return s.toUpperCase();
    }
}

//https://www.baeldung.com/tag/mockito/
