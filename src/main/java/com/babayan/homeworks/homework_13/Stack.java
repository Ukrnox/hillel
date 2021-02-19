package com.babayan.homeworks.homework_13;

import java.util.Arrays;

public class Stack<T> {

    private T[] array;
    private int indicator = -1;

    @SuppressWarnings("unchecked")
    public Stack() {
        Object[] a = new Object[16];
        this.array = (T[]) a;
    }

    private int arrSize() {
        return array.length;
    }

    public int size() {
        return indicator + 1;
    }

    public boolean empty() {
        return array[0] == null;
    }

    public T peek() {
        if (!empty())
            return array[indicator];
        return null;
    }

    public T push(T element) {
        indicator++;
        if (indicator == array.length) {
            addArrSize();
        }
        array[indicator] = element;
        return element;
    }

    public T pop() {
        if (!empty()) {
            T temp = array[indicator];
            array[indicator] = null;
            indicator--;
            if (array.length > 16 && indicator <= array.length / 4) {
                removeArrSize();
            }
            return temp;
        } else return null;
    }

    //возвращает -1 если не нашел element или его номер в стеке с вершины.
    public int search(T element) {
        for (int i = indicator; i >= 0; i--) {
            if (array[i].equals(element)) {
                return (indicator - i + 1);
            }
        }
        return -1;
    }

    public boolean addAll(Stack<T> stack) {
        if (!stack.empty()) {
            for (int i = 0; i <= stack.indicator; i++) {
                push(stack.array[i]);
            }
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 1; i <= size(); i++) {
            System.out.println(i + "-" + array[i - 1]);
        }
        System.out.println();
    }

    private void addArrSize() {
        int newSize = array.length * 2;
        array = Arrays.copyOf(array, newSize);
    }

    private void removeArrSize() {
        int newSize = array.length / 2;
        array = Arrays.copyOf(array, newSize);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append('[');
        for (int i = 0; i <= indicator; i++) {
            string.append(array[i].toString());
            if (i < indicator) {
                string.append(",");
            }
        }
        string.append(']');
        return string.toString();
    }

}
