package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

public class TestVo {
    boolean isCreatedWithDefaultConstructor;
    boolean isCreatedWithIntConstructor;
    int age;
    public int a = 1;
    public int b = 2;
    private int c = 3;
    private int[] array = {4,5,6};

    public int[] getArray() {
        return array;
    }

    public TestVo() {
        isCreatedWithDefaultConstructor = true;
        age = 0;
    }

    public TestVo(int value) {
        isCreatedWithIntConstructor = true;
        age = 1;
    }

    int getAge() {
        return age;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void incrementA() {
        a++;
    }

    public final void incrementB() {
        b++;
    }

}
