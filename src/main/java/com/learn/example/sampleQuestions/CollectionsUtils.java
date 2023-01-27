package com.learn.example.sampleQuestions;

import com.learn.example.common.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionsUtils {


    public static void main(String[] args) {

// Get the Max value of an object collection using a comparator
        Set<Student> studentSet = new HashSet<>(Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39)));
        Student maxStudent = Collections.max(studentSet, (s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge())));
        System.out.println("age : " + maxStudent.getAge());
    }
}
