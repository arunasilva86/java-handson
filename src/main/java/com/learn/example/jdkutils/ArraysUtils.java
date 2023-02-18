package com.learn.example.jdkutils;


import com.learn.example.common.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraysUtils {
    public static void main(String[] args) {

// 1 Sort a primitive or Comparable object array
        System.out.println("--------------------------------------------- TEST-1 ---------------------------------------------");
        int[] ints_1 = new int [] {3, 4, 7, 1, 6, 4};
        Arrays.sort(ints_1);
        Arrays.stream(ints_1).forEach(System.out::println);

// 2 Sort object array  with a comparator
        System.out.println("--------------------------------------------- TEST-2 ---------------------------------------------");
        Student[] students_2 = new Student[] {new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39)};
        Arrays.sort(students_2, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        Arrays.stream(students_2).map(Student::getName).forEach(System.out::println);

// 3 Sort and Binary Search primitive or Comparable object array
        System.out.println("--------------------------------------------- TEST-3 ---------------------------------------------");
        int[] ints_3 = new int [] {3, 4, 7, 1, 6, 4};
        Arrays.sort(ints_3);
        int index_3 = Arrays.binarySearch(ints_3, 6);
        System.out.println("index_3  : " + index_3);

// 4 Sort and Binary Search object array  with a comparator
        System.out.println("--------------------------------------------- TEST-4 ---------------------------------------------");
        Student[] students_4 = new Student[] {new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39)};
        Comparator<Student> NameComparator_4 = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Arrays.sort(students_4, NameComparator_4);
        int index_4 = Arrays.binarySearch(students_4, new Student("Ishara", 33), NameComparator_4);
        System.out.println("index_4  : " + index_4);

    }
}
