package com.babayan.homeworks.homework_20;

public interface Tree<T> {
    void add(T data);

    boolean delete(T data);

    T get(T data);

    void printDfs();

    void printBfs();
}
