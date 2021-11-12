package com.luxoft.oleksandr_shevchenko.datastructures.queue;

import java.util.StringJoiner;

public class ArrayQueue extends AbstractQueue {

    private Object[] array;

    public ArrayQueue() {
        array = new Object[10];
    }

    @Override
    public void enqueue(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return array[0];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInQueue = array[i];
            if (value.equals(valueInQueue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

}
