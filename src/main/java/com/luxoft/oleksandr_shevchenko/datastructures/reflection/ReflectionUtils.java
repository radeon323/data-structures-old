package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

import java.lang.reflect.*;
import java.util.*;


public class ReflectionUtils {

        //    Метод принимает класс и возвращает созданный объект этого класса
    static Object createObject(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor constructor = clazz.getConstructor();
        Object newObject = constructor.newInstance();
        return newObject;
    }


    //    Метод принимает object и вызывает у него все методы без параметров
    static void callAllMethodsWithoutParameters(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getParameters().length == 0) {
                method.invoke(obj);
            }
        }
    }


    //    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    static void showSignatures(Object obj) {
        Class clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    //    Метод принимает Class и выводит все не публичные методы этого класса
    //    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    //    Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+

}

