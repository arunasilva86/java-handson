package com.learn.example.recursion;

public class TestRecusion {
    public static void main(String[] args) {
        int myValue = myFunction(10);
//        System.out.println("myValue is : " + myValue);
    }

    public static int myFunction(int x) {
        if (x < 5) {
            return x;
        }
        int myValue = myFunction(--x);
        System.out.println("x : " + x);
        System.out.println("myValue : " + myValue);
        return myValue;
    }
}
