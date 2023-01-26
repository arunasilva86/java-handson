package com.learn.example.corejava;

import com.learn.example.common.Student;

import java.util.*;

public class TreeSetTest {

    public static void main(String[] args) {

        Student student1 = new Student("Aruna", 20);
        Student student2 = new Student("Ishara", 18);
        Student student3 = new Student("Sanjaya", 40);
        Student student4 = new Student("Romesh", 30);

        List<Student> studentList = new ArrayList(List.of(student1, student2, student3, student4));
//
        Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Student> studentAgeComparator = (o1, o2) -> Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
//
//        Collections.sort(studentList, studentAgeComparator);

        TreeSet<Student> studentTreeSet = new TreeSet<>(studentNameComparator);
        studentTreeSet.addAll(studentList);
        studentTreeSet.stream().forEach(student -> System.out.println(student.getName()));

//        studentList.stream().forEach(student -> System.out.println(student.getName()));

    }
}




