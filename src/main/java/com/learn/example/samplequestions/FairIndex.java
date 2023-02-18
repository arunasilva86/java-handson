package com.learn.example.samplequestions;

import java.util.Arrays;

/*
Find the total number of fair indexes available for two same size arrays.
Any index is a fair index if the sum of the left part of the array is equals to the right part sum and
same is true for the both the array at the same index.
 */

public class FairIndex {
    public static void main(String[] args) {
        int[] A = new int[]{2, -2, 2, -2, 2, -2, 2, 2};
        int[] B = new int[]{2, -2, 2, -2, 2, -2, 2, 2};
        System.out.println("fair index count is : " + solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        // Implement your solution here

        int count = 0;
        int leftSumA = 0;
        int rightSumA = 0;
        int leftSumB = 0;
        int rightSumB = 0;
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int lastBIndex = 1;

        for (int indexA = 1; indexA < A.length; indexA++) {
            leftSumA = leftSumA + A[indexA -1];
            rightSumA = sumA - leftSumA;
            if (leftSumA == rightSumA) {
                for (int indexB = lastBIndex; indexB <= indexA; indexB++) {
                    leftSumB = leftSumB + B[indexB -1];
                }
                lastBIndex = indexA + 1;
                rightSumB = sumB - leftSumB;
                if (leftSumB == rightSumB && leftSumB == leftSumA) {
                    count = count + 1;
                }
            }
        }
        return count;
    }
}
