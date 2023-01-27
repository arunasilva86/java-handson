package com.learn.example.sampleQuestions;

public class StringUtils {

    public static void main(String[] args) {
// Reverse a string  ---------------------------------------------------------------------------------------
        String s = "abcdefghijkl";
        StringBuilder stringBuilder = new StringBuilder("");
        for (int index = s.length() - 1; index >= 0; index-- ) {
            stringBuilder.append(s.charAt(index));
        }
        System.out.println(stringBuilder.toString());
    }
}
