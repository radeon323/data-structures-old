package com.luxoft.oleksandr_shevchenko.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {

    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @DisplayName("Test add and remove work correctly and change size")
    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSize(){
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());
        assertEquals("A", list.remove(0));
        assertEquals("B", list.remove(0));
        assertEquals("C", list.remove(0));
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @DisplayName("Test add with index and change size")
    @Test
    public void testAddWithIndexAndChangeSize(){
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(null);
        list.add(null);
        assertEquals(5, list.size());
        list.add("D",4);
        assertEquals(6, list.size());
        list.add("F",1);
        assertEquals(7, list.size());
        assertEquals("F", list.get(1));
    }

    @DisplayName("Test add and get")
    @Test
    public void testAddAndGet(){
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
    }

    @DisplayName("Test get and set")
    @Test
    public void testGetAndSet(){
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.get(0));
        list.set("D", 1);
        assertEquals("D", list.get(1));
    }

    @DisplayName("Test isEmpty return True on new list")
    @Test
    public void testIsEmptyReturnTrueOnNewAdd(){
        assertTrue(list.isEmpty());
    }

    @DisplayName("Test isEmpty return False on list with data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData(){
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @DisplayName("Test isEmpty return True on list after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear(){
        list.add("A");
        list.add("B");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @DisplayName("Test contains return True")
    @Test
    public void testContainsReturnTrue() {
        list.add("A");
        list.add("B");
        assertTrue(list.contains(new String("A")));
    }

    @DisplayName("Test contains return False")
    @Test
    public void testContainsReturnFalse(){
        list.add("A");
        list.add("B");
        assertFalse(list.contains(new String("C")));
    }

    @DisplayName("Test indexOf")
    @Test
    public void testIndexOf(){
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        assertEquals(0 , list.indexOf("A"));
    }

    @DisplayName("Test indexOf without value")
    @Test
    public void testIndexOfWithoutValue(){
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        assertEquals(-1 , list.indexOf("D"));
    }

    @DisplayName("Test lastIndexOf")
    @Test
    public void testLastIndexOf(){
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        assertEquals(2 , list.lastIndexOf("A"));
    }

    @DisplayName("Test lastIndexOf without value")
    @Test
    public void testLastIndexOfWithoutValue(){
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        assertEquals(-1 , list.lastIndexOf("D"));
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when add out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenAddOut() {
        list.add("A");
        list.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("C", 4);
        });
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when remove out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenRemoveOut() {
        list.add("A");
        list.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when remove on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenRemoveOnEmptyList(){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.remove(0);
        });
    }

    @DisplayName("Test ThrowIndexBoundsOfOutException when get index out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenGetIndexOut() {
        list.add("A");
        list.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when get index on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenGetIndexOnEmptyList() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.get(1);
        });
    }


    @DisplayName("Test ThrowIndexBoundsOfOutException when set index out bounds")
    @Test
    public void testThrowIndexBoundsOfOutExceptionWhenSetIndexOut() {
        list.add("A");
        list.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("A", 2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException when set index on empty list")
    @Test
    public void testThrowIllegalStateExceptionWhenSetIndexOnEmptyList() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.set("A", 2);
        });
    }

    @DisplayName("Test ThrowIllegalStateException indexOf")
    @Test
    public void testThrowIllegalStateExceptionIndexOf() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.indexOf("A");
        });
    }

    @DisplayName("Test ThrowIllegalStateException lastIndexOf")
    @Test
    public void testThrowIllegalStateExceptionLastIndexOf() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.lastIndexOf("A");
        });
    }

    @DisplayName("Test ToString")
    @Test
    public void testToString(){
        list.add("string_1");
        list.add("string_2");
        assertEquals("[string_1, string_2]", list.toString());

    }

}
