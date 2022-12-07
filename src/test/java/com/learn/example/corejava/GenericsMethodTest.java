package com.learn.example.corejava;

import java.util.List;

public class GenericsMethodTest {
    public static void main(String[] args) {
        acceptGeneric(List.of(Integer.valueOf(1234), Integer.valueOf(56657)));
    }
    public static <T extends Number> void acceptGeneric ( List<T > arg) {
        arg.stream().forEach(t -> System.out.println(t.floatValue()));
    }
}
