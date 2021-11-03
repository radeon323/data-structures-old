package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

import com.luxoft.oleksandr_shevchenko.datastructures.list.ArrayList;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;




class ReflectionUtilsTest {


    //    Метод принимает класс и возвращает созданный объект этого класса
    @Test
    public void testCreateObjectBasedOnDefaultConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object obj = ReflectionUtils.createObject(TestVo.class);
        assertNotNull(obj);
        assertEquals(TestVo.class, obj.getClass());
        TestVo testVo = (TestVo) obj;
        assertTrue(testVo.isCreatedWithDefaultConstructor);
        assertFalse(testVo.isCreatedWithIntConstructor);
    }


    //    Метод принимает object и вызывает у него все методы без параметров
    @Test
    public void testCallMethods() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Object obj = ReflectionUtils.createObject(TestVo.class);
        ReflectionUtils.callAllMethodsWithoutParameters(obj);
        assertEquals(2, obj.getClass().getMethod("getA").invoke(obj));
    }


    //    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    @Test
    public void testShowSignatures() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Object obj = ReflectionUtils.createObject(TestVo.class);
        ReflectionUtils.showSignatures(obj);
        String actual = ReflectionUtils.showSignaturesReturn(obj);
        String expected = "public final void com.luxoft.oleksandr_shevchenko.datastructures.reflection.TestVo.incrementB()";
        assertEquals(expected, actual);
    }


    //    Метод принимает Class и выводит все не публичные методы этого класса
    @Test
    public void testGetAllNotPublicMethods() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        assertTrue(ReflectionUtils.getAllNotPublicMethods(TestVo.class).contains("getAge"));
    }
}