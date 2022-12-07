package com.learn.example.recursion;

public class LinkedListReverse {

    public static void main(String[] args) {
        Node node_5 = new Node(null, 5);
        Node node_4 = new Node(node_5, 4);
        Node node_3 = new Node(node_4, 3);
        Node node_2 = new Node(node_3, 2);
        Node node_1 = new Node(node_2, 1);

        printLinkedList(node_1);
        reverse(node_1);
        System.out.println("Reversed values are : ");
        printLinkedList(node_5);

    }

    public static Node reverse (Node node) {
        if (node.getNext() == null) {
            return node;
        }
        reverse (node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return node;
    }

    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

}

class Node {
    private Node next;
    private int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
