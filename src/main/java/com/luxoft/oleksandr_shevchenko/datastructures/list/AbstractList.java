package com.luxoft.oleksandr_shevchenko.datastructures.list;

public abstract class AbstractList implements List {

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

}
