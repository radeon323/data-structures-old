package com.luxoft.oleksandr_shevchenko.datastructures.list;

import java.util.Objects;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
    }

    @Override
    public void add(Object value) {
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index <= size) {
            array[index] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        Object result = array[index];
        for (int i = 0; i < size - 1; i++) {
           if (array[i] == array[index]){
               array[i] = array[i + 1];
           }
        }
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("List index is out of bounds!");
        }
        array[index] = value;
        return array[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

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
        for (int i = 0; i < size; i++) {
            Object valueInList = array[i];
            if (value.equals(valueInList)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(array[i]);
            if (i < size - 1){
                string.append(", ");
            }
        }
        return "[" + string + "]";
    }
}