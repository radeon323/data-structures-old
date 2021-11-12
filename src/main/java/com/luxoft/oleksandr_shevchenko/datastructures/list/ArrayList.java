package com.luxoft.oleksandr_shevchenko.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayList extends AbstractList {

    private class MyIterator implements Iterator {

        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            count++;
            return array[count];
        }
    }

    private Object[] array;

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
        throwExceptions(index);
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
        throwExceptions(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        throwExceptions(index);
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

    @Override
    public MyIterator iterator() {
        return new MyIterator();
    }


}