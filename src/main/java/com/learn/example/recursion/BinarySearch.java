package com.learn.example.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int [] numbers = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("Result is " + isValueContain(numbers, 3, 0, numbers.length-1));
    }
    public static boolean isValueContain (int [] numArray, int number, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;
        if (numArray[midIndex] == number) {
            return true;
        } else if (startIndex == endIndex) {
            return false;
        }
        else if (number < numArray[midIndex]) {
            return isValueContain(numArray, number, startIndex, midIndex -1 );
        }
        else {
            return isValueContain(numArray, number, midIndex + 1, endIndex );
        }
    }
}
