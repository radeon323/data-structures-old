package com.luxoft.oleksandr_shevchenko.datastructures.list;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {

    private static class Node {
        private Object value;
        private Node next;
        private Node prev;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    private Node head;
    private Node tail;

    private Node getNodeByIndex(int index) {
        Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        return current;
    }


    @Override
    public void add(Object value) {
        add(value, size - 1);
    }

    @Override
    public void add(Object value, int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size - 1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Node current = head;
        if (size == 1 && index == 0) {
            clear();
        } else if (index == size - 1) {
            current = tail;
            tail.prev.next = null;
            tail = tail.prev;
        } else if (index == 0) {
            head.next.prev = null;
            head = head.next;
        } else {
            current = getNodeByIndex(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        if (size != 0){
            size--;
        }
        return current.getValue();
    }

    @Override
    public Object get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        return getNodeByIndex(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Objects.checkIndex(index, size);
        Node current = getNodeByIndex(index);
        current.value = value;
        return current;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        Node current = head;
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }
}
