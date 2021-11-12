package com.luxoft.oleksandr_shevchenko.datastructures.queue;

public class LinkedQueueTest extends AbstractQueueTest {
    @Override
    protected Queue getQueue() {
        return new LinkedQueue();
    }
}
