package com.learn.example.sampleQuestions;

import com.learn.example.common.Student;

import java.util.Arrays;
import java.util.List;

public class StreamsUtils {
    public static void main(String[] args) {

//  Sum of the ages of a list of students
//  Min / Max / Average / Count are also same
        List<Student> studentList_1 = Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39));
        int ageSum = studentList_1.stream().mapToInt(Student::getAge).sum();
        System.out.println("Age SUm is : " + ageSum);

// Sort a List with Stream
        List<Student> studentList_2 = Arrays.asList(new Student("Romesh", 39), new Student("Ishara", 33), new Student("Aruna", 36));
        studentList_2.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);



        


    }



}
