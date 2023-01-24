package com.learn.example.corejava;


import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        // initialize the queue with a given comparator
        PriorityQueue<Person> personPriorityQueue = new PriorityQueue<>((a, b) -> Integer.valueOf(a.getAge()).compareTo(Integer.valueOf(b.getAge())));

        personPriorityQueue.add(new Person("aaa", 40));
        personPriorityQueue.add(new Person("bbb", 30));
        personPriorityQueue.add(new Person("ccc", 50));
        personPriorityQueue.add(new Person("ddd", 10));
        personPriorityQueue.add(new Person("eee", 60));
        personPriorityQueue.add(new Person("fff", 20));

        // first element will always be the sorted (smallest) element
        System.out.println("First element : " + personPriorityQueue.peek());

        // remaining element wii not be sorted when stored.
        System.out.println("All elements in the queue : " + personPriorityQueue);

        //  But at the retrieval time sorted item (head) will be returned all the time
        int size = personPriorityQueue.size();
        for (int x = 0; x < size; x++) {
            System.out.println("Element retrieved : " + personPriorityQueue.poll());
        }

    }
}
