package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

import com.luxoft.oleksandr_shevchenko.datastructures.list.ArrayList;
import java.lang.reflect.*;


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
    static String showSignaturesReturn(Object obj) {
        Class clazz = obj.getClass();
        ArrayList arrayList = new ArrayList();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
                arrayList.add(obj);
            }
        }
        return arrayList.toString();
    }


    //    Метод принимает Class и выводит все не публичные методы этого класса
    static String getAllNotPublicMethods(Class clazz) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        Object newObject = createObject(clazz);
        Method[] finalMethod = newObject.getClass().getDeclaredMethods();
        for (Method method : finalMethod) {
            if(!Modifier.isPublic(method.getModifiers())){
                arrayList.add(method);
            }
        }
        return arrayList.toString();
    }


    //    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует



    //    Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+

}

