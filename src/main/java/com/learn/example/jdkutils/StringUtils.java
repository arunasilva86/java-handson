package com.learn.example.jdkutils;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.util.stream.Stream;

public class StringUtils {

    public static void main(String[] args) {
        reverseAString();
        integerToStringArray();

    }

// Reverse a string  ---------------------------------------------------------------------------------------
    public static void reverseAString () {
        String s = "abcdefghijkl";
        StringBuilder stringBuilder = new StringBuilder("");
        for (int index = s.length() - 1; index >= 0; index-- ) {
            stringBuilder.append(s.charAt(index));
        }
        System.out.println(stringBuilder.toString());

    }

// get the string array of an integer
    public static void integerToStringArray () {
        int n = 133708546;
        String [] strings = String.valueOf(Math.abs(n)).split("(?!^)");
        Stream.of(strings).forEach(s -> System.out.println("value : " + s));
    }
}
