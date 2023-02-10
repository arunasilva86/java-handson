package com.learn.example.JavaUtilFunctions;

import com.learn.example.common.ClassRoom;
import com.learn.example.common.Student;

import java.util.Arrays;
import java.util.List;

public class StreamsUtils {
    public static void main(String[] args) {

//  Sum of the ages of a list of students
//  Min / Max / Average / Count are also same
        System.out.println("--------------------------------------------- TEST-1 ---------------------------------------------");
        List<Student> studentList_1 = Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33), new Student("Romesh", 39));
        int ageSum = studentList_1.stream().mapToInt(Student::getAge).sum();
        System.out.println("Age SUm is : " + ageSum);

// Sort a List with Stream
        System.out.println("--------------------------------------------- TEST-2 ---------------------------------------------");
        List<Student> studentList_2 = Arrays.asList(new Student("Romesh", 39), new Student("Ishara", 33), new Student("Aruna", 36));
        studentList_2.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);

// Sort a distinct List with Stream
        System.out.println("--------------------------------------------- TEST-3 ---------------------------------------------");
        List<Student> studentList_3 = Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33), new Student("Aruna", 36));
        studentList_3.stream().distinct().forEach(System.out::println);

// Flatmap
        System.out.println("--------------------------------------------- TEST-4 ---------------------------------------------");
        List<Student> studentList_4_1 = Arrays.asList(new Student("Aruna", 36), new Student("Ishara", 33));
        List<Student> studentList_4_2 = Arrays.asList(new Student("Sanjaya", 42), new Student("Romesh", 39));
        List<ClassRoom> classRooms = Arrays.asList(new ClassRoom(studentList_4_1), new ClassRoom(studentList_4_2));
        int ageSum_4 = classRooms.stream()
                .flatMap(classRoom -> classRoom.getStudentList().stream())
                .filter(student -> student.getAge() < 40)
                .mapToInt(student -> student.getAge())
                .sum();
        System.out.println("Age sum : " + ageSum_4);

// reduce () SUM
        System.out.println("--------------------------------------------- TEST-5 ---------------------------------------------");
        int[] numbers = new int[] {4, 2, 7, 4, 8, 1};
        int sum = Arrays.stream(numbers).reduce(0, (x, y) -> x + y);
        System.out.println("Sum : " + sum);

// reduce String concatenation
        System.out.println("--------------------------------------------- TEST-6 ---------------------------------------------");
        List<String> stringList = List.of("xxx", "yyy", "zzz");
        String finalString = stringList.stream().reduce((s1, s2) -> s1 + s2).orElse(""); // optional  or orElse needed when no identity value is defined
        System.out.println(finalString);


    }



}
