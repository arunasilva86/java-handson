package com.learn.example.common;

import java.util.List;

public class ClassRoom {

    private List<Student> studentList;

    public ClassRoom(List<Student> students) {
        this.studentList = students;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
