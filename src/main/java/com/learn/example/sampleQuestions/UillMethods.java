package com.learn.example.sampleQuestions;


import com.learn.example.common.Student;

import java.util.Arrays;
import java.util.Collections;

public class UillMethods {
    public static void main(String[] args) {

// Reverse a string  ---------------------------------------------------------------------------------------
        String s = "abcdefghijkl";
        StringBuilder stringBuilder = new StringBuilder("");
        for (int index = s.length() - 1; index >= 0; index-- ) {
            stringBuilder.append(s.charAt(index));
        }
        System.out.println(stringBuilder.toString());

// Sort a primitive array  ---------------------------------------------------------------------------------------
        int[] ints = new int [] {3, 4, 7, 1, 6, 4};
        Arrays.sort(ints);
        Arrays.stream(ints).forEach(System.out::println);

// Sort object array  with a comparator---------------------------------------------------------------------------------------
        Student[] students = new Student[] {new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39)};
        Arrays.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        Arrays.stream(students).map(Student::getName).forEach(System.out::println);

    }
}
