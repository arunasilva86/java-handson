package com.learn.example.samplequestions;

/*
Write a function:

class Solution { public int solution(int[] A); }


that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

* */

import java.util.Arrays;

public class MissingSmallestNumber {
    public static void main(String[] args) {
        int[] A = new int[]{1, -3, 5, -6, 0, 4, 1, 2};
        System.out.println("Missing Smallest Positive Integer is : " + getMissingSmallestPositiveInt(A));
    }

    public static int getMissingSmallestPositiveInt(int[] A) {
        int[] sortedPositives = Arrays.stream(A).filter(value -> value > 0).sorted().toArray();

        for (int integer = 1; integer <= 100000; integer++) {
            int value = Arrays.binarySearch(sortedPositives, integer);
            if (value < 0) {
                return integer;
            }
        }
        return 1;
    }
}
