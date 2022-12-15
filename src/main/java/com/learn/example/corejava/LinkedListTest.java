package com.learn.example.corejava;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>(List.of(
                new Person("xxxx", 40),
                new Person("yyyy", 30),
                new Person("zzzz", 10),
                new Person("pppp", 70)));
        int size = personList.size();

        // LinkedList list behavior
        System.out.println("Person at dynamic index 2 = " + personList.get(2).getName());

        for (int x = 0; x < size; x++) {

            // linked list's queue behavior
            System.out.println(personList.poll().getName() + " New size = " + personList.size());
        }
    }
}
