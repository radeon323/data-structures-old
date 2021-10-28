package com.luxoft.oleksandr_shevchenko.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @DisplayName("Test add and remove work correctly and change size")
    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        assertEquals("A", arrayList.remove(0));
        assertEquals("B", arrayList.remove(0));
        assertEquals("C", arrayList.remove(0));
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Test add with index and change size")
    @Test
    public void testAddWithIndexAndChangeSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(null);
        arrayList.add(null);

        assertEquals(5, arrayList.size());
        arrayList.add("D",4);
        assertEquals(6, arrayList.size());
        arrayList.add("F",1);
        assertEquals(7, arrayList.size());
        assertEquals("F", arrayList.get(1));

    }

    @DisplayName("Test add and get")
    @Test
    public void testAddAndGet(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertEquals(2, arrayList.size());
        assertEquals("A", arrayList.get(0));
        assertEquals("A", arrayList.get(0));
        assertEquals(2, arrayList.size());
    }

    @DisplayName("Test get and set")
    @Test
    public void testGetAndSet(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("A", arrayList.get(0));
        arrayList.set("D", 1);
        assertEquals("D", arrayList.get(1));
    }

    @DisplayName("Test isEmpty return True on new list")
    @Test
    public void testIsEmptyReturnTrueOnNewAdd(){
        ArrayList arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Test isEmpty return False on list with data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertFalse(arrayList.isEmpty());
    }

    @DisplayName("Test isEmpty return True on list after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Test contains return True")
    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertTrue(arrayList.contains(new String("A")));
    }

    @DisplayName("Test contains return False")
    @Test
    public void testContainsReturnFalse(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertFalse(arrayList.contains(new String("C")));
    }

    @DisplayName("Test contains return False on empty list")
    @Test
    public void testContainsReturnFalseOnEmptyList(){
        ArrayList arrayList = new ArrayList();
        assertFalse(arrayList.contains("C"));
    }

    @DisplayName("Test indexOf")
    @Test
    public void testIndexOf(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(0 , arrayList.indexOf("A"));
    }

    @DisplayName("Test indexOf without value")
    @Test
    public void testIndexOfWithoutValue(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(-1 , arrayList.indexOf("D"));
    }

    @DisplayName("Test lastIndexOf")
    @Test
    public void testLastIndexOf(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(2 , arrayList.lastIndexOf("A"));
    }

    @DisplayName("Test lastIndexOf without value")
    @Test
    public void testLastIndexOfWithoutValue(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(-1 , arrayList.lastIndexOf("D"));
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when add out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenAddOut() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("C", 4);
        });
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when remove out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenRemoveOut() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when remove on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenRemoveOnEmptyList(){
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.remove(0);
        });
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when get index out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenGetIndexOut() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when get index on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenGetIndexOnEmptyList() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.get(1);
        });
    }


    @DisplayName("Test ThrowIndexBoundsOfOutException when set index out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenSetIndexOut() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("A", 2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when set index on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenSetIndexOnEmptyList() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.set("A", 2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException indexOf")
    @Test
    public void testThrowIllegalStateExceptionIndexOf() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.indexOf("A");
        });
    }

    @DisplayName("Test ThrowIllegalStateException lastIndexOf")
    @Test
    public void testThrowIllegalStateExceptionLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.lastIndexOf("A");
        });
    }

    @DisplayName("Test ToString")
    @Test
    public void testToString(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("string_1");
        arrayList.add("string_2");

        assertEquals("[string_1, string_2]", arrayList.toString());

    }

}
