package com.babayan.homeworks.homework_20;

/**
 * Если size типа int то сколько элементов может вместить Список?
 * Зависит от реализации, но после переполнения int будет удивлять.
 * Сколько памяти он займет?
 * Память для хранения всех элементов + память на все ссылки(узлы).
 */
public interface MyList<T> {
    void add(T data);

    boolean remove(T index);

    T get(int index);

    int size();

    String toString();
}
