package com.babayan.homeworks.homework_20;

public interface MyListIterator<T> {

    boolean hasNext();

    T next();

    void remove();

    boolean hasPrevious();

    T previous();

    int getIndex();

    void toBeginningNext();

    void iteratorToTheIndex(int index);

    T getCurrentVal();
}