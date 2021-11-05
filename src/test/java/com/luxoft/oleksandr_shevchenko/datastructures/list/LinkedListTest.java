package com.luxoft.oleksandr_shevchenko.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LinkedListTest {

    @DisplayName("Test add and remove work correctly and change size")
    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSize(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertEquals(3, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
        assertEquals("C", linkedList.remove(2));
        assertEquals("B", linkedList.remove(1));
        assertEquals("A", linkedList.remove(0));
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("Test add with index and change size")
    @Test
    public void testAddWithIndexAndChangeSize(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add(null);
        linkedList.add(null);

        assertEquals(5, linkedList.size());
        linkedList.add("D",4);
        assertEquals(6, linkedList.size());
        linkedList.add("F",1);
        assertEquals(7, linkedList.size());
        assertEquals("F", linkedList.get(1));

    }

    @DisplayName("Test add and get")
    @Test
    public void testAddAndGet(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("A", linkedList.get(0));
        assertEquals(2, linkedList.size());
    }

    @DisplayName("Test get and set")
    @Test
    public void testGetAndSet(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertEquals("A", linkedList.get(0));
        linkedList.set("D", 1);
        assertEquals("D", linkedList.get(1));
    }

    @DisplayName("Test isEmpty return True on new list")
    @Test
    public void testIsEmptyReturnTrueOnNewAdd(){
        LinkedList linkedList = new LinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("Test isEmpty return False on list with data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        assertFalse(linkedList.isEmpty());
    }

    @DisplayName("Test isEmpty return True on list after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("Test contains return True")
    @Test
    public void testContainsReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertTrue(linkedList.contains(new String("A")));
    }

    @DisplayName("Test contains return False")
    @Test
    public void testContainsReturnFalse(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertFalse(linkedList.contains(new String("C")));
    }

    @DisplayName("Test contains return False on empty list")
    @Test
    public void testContainsReturnFalseOnEmptyList(){
        LinkedList linkedList = new LinkedList();
        assertFalse(linkedList.contains("C"));
    }

    @DisplayName("Test indexOf")
    @Test
    public void testIndexOf(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        assertEquals(0 , linkedList.indexOf("A"));
    }

    @DisplayName("Test indexOf without value")
    @Test
    public void testIndexOfWithoutValue(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        assertEquals(-1 , linkedList.indexOf("D"));
    }

    @DisplayName("Test lastIndexOf")
    @Test
    public void testLastIndexOf(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        assertEquals(2 , linkedList.lastIndexOf("A"));
    }

    @DisplayName("Test lastIndexOf without value")
    @Test
    public void testLastIndexOfWithoutValue(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        assertEquals(-1 , linkedList.lastIndexOf("D"));
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when add out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenAddOut() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("C", 4);
        });
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when remove out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenRemoveOut() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when remove on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenRemoveOnEmptyList(){
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.remove(0);
        });
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when get index out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenGetIndexOut() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when get index on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenGetIndexOnEmptyList() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.get(1);
        });
    }


    @DisplayName("Test ThrowIndexBoundsOfOutException when set index out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenSetIndexOut() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.set("A", 2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when set index on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenSetIndexOnEmptyList() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.set("A", 2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException indexOf")
    @Test
    public void testThrowIllegalStateExceptionIndexOf() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.indexOf("A");
        });
    }

    @DisplayName("Test ThrowIllegalStateException lastIndexOf")
    @Test
    public void testThrowIllegalStateExceptionLastIndexOf() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedList.lastIndexOf("A");
        });
    }

    @DisplayName("Test ToString")
    @Test
    public void testToString(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("string_1");
        linkedList.add("string_2");

        assertEquals("[string_1, string_2]", linkedList.toString());

    }
}
