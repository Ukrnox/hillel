package com.babayan.homeworks.homework_20;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree<E extends Comparable<E>> implements Tree<E> {
    private Node<E> root;

    private Node<E> findNode(E value) {
        if (root == null) {
            return null;
        }
        Node<E> current = root;
        while (!current.value.equals(value)) {
            if (value.compareTo(current.value) < 0)
                current = current.leftChild;
            else if (value.compareTo(current.value) > 0) {
                current = current.rightChild;
            }
            if (current == null)
                return null;
        }
        return current;
    }

    public boolean find(E value) {
        return findNode(value) != null;
    }

    @Override
    public void add(E value) {
        Node<E> node = new Node<>(value);
        if (root == null) {
            root = node;
        } else {
            Node<E> current = root;
            Node<E> parent;
            while (true) {
                parent = current;
                if (value.compareTo(current.value) < 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean delete(E value) {
        Node<E> current = root;
        Node<E> parent = root;
        boolean isLeftChild = true;
        while (current.value != value) {
            parent = current;
            if (value.compareTo(current.value) < 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node<E> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
        return true;
    }

    @Override
    public E get(E data) {
        if (findNode(data) != null) {
            return findNode(data).value;
        }
        return null;
    }

    @Override
    public void printBfs() {
        System.out.println(toString());
    }

    private Node<E> getSuccessor(Node<E> delNode) {
        Node<E> successorParent = delNode;
        Node<E> successor = delNode;
        Node<E> current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    private class Node<T> {
        private final T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        Node(T value) {
            this.value = value;
        }
    }

    private String inOrder(Node<E> root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(inOrder(root.leftChild)).append("|");
            sb.append(root.value.toString());
            sb.append(inOrder(root.rightChild));
        }
        return sb.toString();
    }

    @Override
    public void printDfs() {
        if (root == null) {
            return;
        }
        Queue<Node<E>> coll = new LinkedList<>();
        coll.add(root);
        while (!coll.isEmpty()) {
            Node<E> temp = coll.poll();
            System.out.print(" | " + temp.value + " | ");
            if (temp.leftChild != null) {
                coll.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                coll.add(temp.rightChild);
            }
        }

    }

    @Override
    public String toString() {
        return inOrder(root);
    }
}