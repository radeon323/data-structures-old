package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

import com.luxoft.oleksandr_shevchenko.datastructures.list.ArrayList;
import org.junit.jupiter.api.Test;
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
    public void testCallMethods() throws InvocationTargetException, IllegalAccessException {
        TestVo testVo = new TestVo();
        ReflectionUtils.callAllMethodsWithoutParameters(testVo);
        assertEquals(2, testVo.getA());
    }


    //    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    @Test
    public void testShowSignatures() throws InvocationTargetException, IllegalAccessException {
        TestVo testVo = new TestVo();
        ReflectionUtils.showSignatures(testVo);
        assertEquals(3, testVo.getB());
        assertTrue(testVo.trueFalse());
    }


    //    Метод принимает Class и выводит все не публичные методы этого класса
    @Test
    public void testGetAllNotPublicMethods() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        assertTrue(ReflectionUtils.getAllNotPublicMethods(TestVo.class).contains("getAge"));
    }


    //    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    //    не знаю як зробити тест
    @Test
    public void testGetAllSuperClassesAndInterfaces() {
        ReflectionUtils.getAllSuperClassesAndInterfaces(ArrayList.class);
    }


    //    Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    @Test
    public void testChangePrivateFieldsToDefault() throws IllegalAccessException {
        TestVo testVo = new TestVo();
        ReflectionUtils.changePrivateFieldsToDefault(testVo);
        assertEquals(0, testVo.getC());
        assertNull(testVo.getArray());
    }

}
