package com.learn.example.corejava;

import java.util.Arrays;
import java.util.List;

public class StreamsBehaviorTest {
    public static void main (String []  args) {
        List<Integer> myList = Arrays.asList(1, 2,3, 4, 5, 6, 7, 8, 9);
        myList.stream()
                .filter(StreamsBehaviorTest::isEven)
                .map(StreamsBehaviorTest::multiplyByHun)
                .filter(StreamsBehaviorTest::isGreaterThan5)
                .sorted((o1, o2) -> o1 - o2)
                .map(StreamsBehaviorTest::addOne)
                .anyMatch(x -> x > 700);
    }

    public static boolean isEven (int x) {
        System.out.println("Inside isEven " + x);
        return x % 2 == 0;
    }

    public static int multiplyByHun (int x) {
        System.out.println("Inside multiplyByHun " + x);
        return x * 100;
    }

    public static boolean isGreaterThan5 (int x) {
        System.out.println("Inside isGreaterThan5 " + x);
        return x > 500;
    }

    public static int addOne (int x) {
        System.out.println("Inside addOne " + x);
        return x + 1;
    }
}
