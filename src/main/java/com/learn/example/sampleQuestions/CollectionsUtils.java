package com.learn.example.sampleQuestions;

import com.learn.example.common.Student;

import java.util.*;

public class CollectionsUtils {


    public static void main(String[] args) {

// Sort is same as Arrays

// Binary Search is same as Arrays

// Max of Comparable objects
        System.out.println("--------------------------------------------- TEST-1 ---------------------------------------------");
        List<Integer> integers_1 = List.of(5, 2, 15, 4, 6, 1, 9);
        System.out.println("Max int is : " + Collections.max(integers_1));

// Get the Max value of an object collection using a comparator
        System.out.println("--------------------------------------------- TEST-2 ---------------------------------------------");
        Set<Student> studentSet_2 = new HashSet<>(Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39)));
        Student maxStudent = Collections.max(studentSet_2, (s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge())));
        System.out.println("age : " + maxStudent.getAge());

// Collection swap elements at given positions
        System.out.println("--------------------------------------------- TEST-3 ---------------------------------------------");
        List<Student> studentList_3 = Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39));
        Collections.swap(studentList_3, 1, 2);
        System.out.println("Student at 1st index is : " + studentList_3.get(1).getName());

    }
}
