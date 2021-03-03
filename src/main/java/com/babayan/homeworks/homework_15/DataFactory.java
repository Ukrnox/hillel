package com.babayan.homeworks.homework_15;

import lombok.Getter;

@Getter
public abstract class DataFactory {

    private final String path;

    public DataFactory(String path) {
        this.path = path;
    }

    abstract public DataProvider createData();

    abstract public DataProvider createData(Mapper mapper);
}
