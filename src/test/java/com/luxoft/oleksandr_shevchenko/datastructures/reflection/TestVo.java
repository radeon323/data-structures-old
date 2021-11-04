package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

public class TestVo {
    boolean isCreatedWithDefaultConstructor;
    boolean isCreatedWithIntConstructor;
    int age;
    public int a = 1;
    public int b = 2;
    private int c = 3;
    private int[] array = {4,5,6};
    private boolean bool = true;

    public boolean isBool() {
        return bool;
    }

    public int[] getArray() {
        return array;
    }

    public TestVo() {
        isCreatedWithDefaultConstructor = true;
    }

    public TestVo(int value) {
        isCreatedWithIntConstructor = true;
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

    public final boolean trueFalse() {
        return true;
    }

}
