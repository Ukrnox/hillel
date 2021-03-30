package com.babayan.homeworks.homework_20;

/**
 * Если size типа int то сколько элементов может вместить Список?
 * Зависит от реализации, по сути ограничен только памятью, но после переполнения int будет удивлять.
 * Сколько памяти он займет?
 * Память для хранения всех элементов(узлов)(ссыллок).
 */
public interface MyList<T> {
    void add(T data);

    boolean remove(T index);

    T get(int index);

    int size();

    String toString();
}
