package com.luxoft.oleksandr_shevchenko.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @DisplayName("Test enqueue and dequeue work correctly and change size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("Test enqueue and peek")
    @Test
    public void testEnqueueAndPeek(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
    }

    @DisplayName("Test isEmpty return True on new queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("Test isEmpty return False on queue with data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }

    @DisplayName("Test isEmpty return True on queue after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("Test contains return True")
    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertTrue(arrayQueue.contains(new String("A")));
    }

    @DisplayName("Test contains return False")
    @Test
    public void testContainsReturnFalse(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertFalse(arrayQueue.contains(new String("C")));
    }

    @DisplayName("Test contains return False on empty queue")
    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("C"));
    }

    @DisplayName("Test ThrowIllegalStateException when dequeue on empty queue")
    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @DisplayName("Test ToString")
    @Test
    public void testToString(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("string_1");
        arrayQueue.enqueue("string_2");

        assertEquals("[string_1, string_2]", arrayQueue.toString());

    }

}
