package com.luxoft.oleksandr_shevchenko.datastructures.reflection;

public class TestVo {
    boolean isCreatedWithDefaultConstructor;
    boolean isCreatedWithIntConstructor;
    int age;
    public int a = 1;
    public int b = 2;


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

    public void incrementA() {
        a++;
    }

    public final void incrementB() {
        b++;
    }

}
