package com.learn.example.common;

import java.util.List;

public class ClassRoom {

    private List<Student> students;

    public ClassRoom(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
