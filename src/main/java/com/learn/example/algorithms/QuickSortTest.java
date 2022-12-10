package com.learn.example.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortTest {
    public static void main(String[] args) {
        List<Student> studentListImmutable = List.of(
                new Student("Aruna", 40),
                new Student("Ishara", 10),
                new Student("Romesh", 35),
                new Student("Sanjaya", 60),
                new Student("Dhanushka", 40),
                new Student("Madhu", 10),
                new Student("Preethika", 35),
                new Student("Niru", 61),
                new Student("Inoshika", 21));
        List<Student> studentList = new ArrayList<>(studentListImmutable);
        quickSort(studentList, 0, studentList.size() -1, 0);
        studentList.stream().forEach(student -> System.out.println(student.getName() + " " + student.getAge()));

    }

    private static void quickSort (List<Student> studentList, int startIndex, int endIndex,int positionIndex) {
        if (startIndex == endIndex) {
            return;
        }
        Student pivotStudent = studentList.get(endIndex);
        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (studentList.get(currentIndex).getAge() < pivotStudent.getAge()) {
                Collections.swap(studentList, positionIndex, currentIndex);
                positionIndex++;
            }
        }

        Collections.swap(studentList, positionIndex, endIndex);
        if (startIndex < positionIndex) {
            quickSort(studentList, startIndex, positionIndex -1, startIndex);
        }
        if (positionIndex < endIndex) {
            quickSort(studentList, positionIndex + 1, endIndex, positionIndex + 1);
        }
    }

}


class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
