package com.learn.example.recursion;

public class LinkedListMerge {

    public static void main(String[] args) {

    }

    public static Node mergeLists (Node minNode, Node maxNode) {

        if (minNode.getValue() > maxNode.getValue()) {
            Node node = minNode.getNext();
            minNode.setNext(maxNode);
            return node;
        }

        Node nextNode = mergeLists(minNode.getNext(), maxNode);

// TODO
        return nextNode;

    }

    private static Node getMinNode (Node listOneNode, Node listTwoNode) {
        return listOneNode.getValue() < listTwoNode.getValue() ? listOneNode  : listTwoNode;
    }

    private static Node getMaxNode (Node listOneNode, Node listTwoNode) {
        return listOneNode.getValue() <= listTwoNode.getValue() ? listTwoNode  : listOneNode;
    }
}


