package com.luxoft.oleksandr_shevchenko.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class linkedQueueTest {


    @DisplayName("Test enqueue and dequeue work correctly and change size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertEquals(2, linkedQueue.size());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("Test enqueue and peek")
    @Test
    public void testEnqueueAndPeek(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertEquals(2, linkedQueue.size());
        assertEquals("A", linkedQueue.peek());
        assertEquals("A", linkedQueue.peek());
        assertEquals(2, linkedQueue.size());
    }

    @DisplayName("Test isEmpty return True on new queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue(){
        LinkedQueue linkedQueue = new LinkedQueue();
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("Test isEmpty return False on queue with data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        assertFalse(linkedQueue.isEmpty());
    }

    @DisplayName("Test isEmpty return True on queue after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.clear();
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("Test contains return True")
    @Test
    public void testContainsReturnTrue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        assertTrue(linkedQueue.contains(new String("A")));
    }

    @DisplayName("Test contains return False")
    @Test
    public void testContainsReturnFalse(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        assertFalse(linkedQueue.contains(new String("C")));
    }

    @DisplayName("Test contains return False on empty queue")
    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        LinkedQueue linkedQueue = new LinkedQueue();
        assertFalse(linkedQueue.contains("C"));
    }

    @DisplayName("Test ThrowIllegalStateException when dequeue on empty queue")
    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue(){
        LinkedQueue linkedQueue = new LinkedQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedQueue.dequeue();
        });
    }

    @DisplayName("Test ToString")
    @Test
    public void testToString(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("string_1");
        linkedQueue.enqueue("string_2");

        assertEquals("[string_1, string_2]", linkedQueue.toString());

    }


}
