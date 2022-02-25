package com.interviews.java.generics;

class MyGenClass<T1, T2> {
    private T1 obj1;
    private T2 obj2;

    T1 add(T1 obj1, T2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        return obj1;
    }

    T1 get() {
        System.out.println("Value: " + obj1);
        return obj1;
    }

    void put(T1 a) {
        this.obj1 = a;
    }

}