package com.luxoft.oleksandr_shevchenko.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractQueueTest {

    private Queue queue;

    @BeforeEach
    public void before() {
        queue = getQueue();
    }

    protected abstract Queue getQueue();

    @DisplayName("Test enqueue and dequeue work correctly and change size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize(){
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @DisplayName("Test enqueue and peek")
    @Test
    public void testEnqueueAndPeek(){
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());
        assertEquals("A", queue.peek());
        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());
    }

    @DisplayName("Test isEmpty return True on new queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue(){
        assertTrue(queue.isEmpty());
    }

    @DisplayName("Test isEmpty return False on queue with data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData(){
        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @DisplayName("Test isEmpty return True on queue after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear(){
        queue.enqueue("A");
        queue.enqueue("B");
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @DisplayName("Test contains return True")
    @Test
    public void testContainsReturnTrue() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertTrue(queue.contains(new String("A")));
    }

    @DisplayName("Test contains return False")
    @Test
    public void testContainsReturnFalse(){
        queue.enqueue("A");
        queue.enqueue("B");
        assertFalse(queue.contains(new String("C")));
    }

    @DisplayName("Test contains return False on empty queue")
    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        assertFalse(queue.contains("C"));
    }

    @DisplayName("Test ThrowIllegalStateException when dequeue on empty queue")
    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue(){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }

    @DisplayName("Test ToString")
    @Test
    public void testToString(){
        queue.enqueue("string_1");
        queue.enqueue("string_2");
        assertEquals("[string_1, string_2]", queue.toString());
    }
    
}
