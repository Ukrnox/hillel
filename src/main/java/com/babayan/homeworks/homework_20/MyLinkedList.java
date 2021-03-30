package com.babayan.homeworks.homework_20;

import java.util.*;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        this.first = null;
        size = 0;
    }

    @Override
    public void add(E value) {
        int tempInt = size;
        Node<E> item = new Node<>(value);
        if (first == null) {
            first = item;
            last = item;
            size++;
        } else {
            Node<E> tempF = first;
            while (tempF.next != null) {
                tempF = tempF.next;
            }
            tempF.next = item;
            last = item;
            last.previous = tempF;
            size++;
        }
    }

    @Override
    public E get(int index) {
        MyListIterator<E> itr = this.listIterator();
        if (index > this.size) {
            return null;
        }
        itr.iteratorToTheIndex(index);
        return itr.getCurrentVal();
    }

    public MyListIterator<E> listIterator() {
        return new MyListIterator<>() {
            private Node<E> currentValue;
            private Node<E> next;
            private int index = 0;

            @Override
            public E getCurrentVal() {
                return currentValue.value;
            }

            @Override
            public void iteratorToTheIndex(int index) {
                if (index > size()) {
                    return;
                }
                int temp = 0;
                while (temp != index) {
                    next();
                    temp++;
                }
            }

            @Override
            public void toBeginningNext() {
                currentValue = first;
                next = currentValue.next;
                index = 1;
            }

            @Override
            public int getIndex() {
                return index;
            }

            @Override
            public boolean hasNext() {
                if (index == 0) {
                    return first != null;
                }
                return index < size && currentValue.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (index == 0) {
                    currentValue = first;
                    index++;
                    return currentValue.value;
                }
                currentValue = currentValue.next;
                next = currentValue.next;
                index++;
                return currentValue.value;
            }

            @Override
            public boolean hasPrevious() {
                return currentValue.previous != null;
            }

            @Override
            public E previous() {
                return currentValue.previous == null ? null : currentValue.previous.value;
            }

            @Override
            public void remove() {
                if (currentValue == null)
                    throw new IllegalStateException();
                Node<E> temp = currentValue;
                next = currentValue.next;
                unlink(currentValue);
                currentValue = null;
                index--;
            }
        };
    }

    @Override
    public boolean remove(E value) {
        if (first == null) {
            return false;
        }
        Node<E> tempF = first;
        while (tempF != null) {
            if (tempF.value.equals(value)) {
                unlink(tempF);
                return true;
            }
            tempF = tempF.next;
        }
        return false;
    }

    private E unlink(Node<E> node) {
        E value = node.value;
        Node<E> next = node.next;
        Node<E> previous = node.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            node.previous = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            node.next = null;
        }

        node.value = null;
        size--;
        return value;
    }

    public boolean removeFirst() {
        if (first != null) {
            first.next.previous = null;
            first = first.next;
            size--;
            return true;
        }
        return false;
    }

    public boolean removeLast() {
        if (last != null) {
            last = last.previous;
            last.next = null;
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean contains(E o) {
        MyListIterator<E> iterator = this.listIterator();
        if (first.value.equals(o)) {
            return true;
        }
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.equals(o)) {
                return true;
            }
        }
        return false;
    }

    private class Node<T> {
        protected T value;
        protected Node<T> next;
        protected Node<T> previous;

        private Node(T item) {
            this.value = item;
        }
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder(first.value.toString());
        Node<E> temp = first;
        while (temp.next != null) {
            line.append(" : ");
            line.append(temp.next.value.toString());
            temp = temp.next;
        }
        return line.toString();
    }
}