package com.luxoft.oleksandr_shevchenko.datastructures.queue;

public class ArrayQueueTest extends AbstractQueueTest{
    @Override
    protected Queue getQueue() {
        return new ArrayQueue();
    }

}
