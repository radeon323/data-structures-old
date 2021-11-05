package com.luxoft.oleksandr_shevchenko.datastructures.list;

public class Node {
    Object value;
    Node next;
    Node prev;

    public Node(Object value) {
        this.value = value;

    }

    public Object getValue() {
        return value;
    }
}
