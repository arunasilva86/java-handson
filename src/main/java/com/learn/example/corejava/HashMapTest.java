package com.learn.example.corejava;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {

        Map<Person, Integer> personMap = new HashMap();
        personMap.put(new Person("Aruna", 30), 30);

        Integer age = personMap.get(new Person("Aruna", 30));
        System.out.println("Age is : " + age.intValue());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
