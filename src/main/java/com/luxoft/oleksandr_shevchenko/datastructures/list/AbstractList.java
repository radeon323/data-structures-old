package com.luxoft.oleksandr_shevchenko.datastructures.list;

public abstract class AbstractList implements List, Iterable {

    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public void throwExceptions(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
    }

    public void throwExceptions() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
    }



}
