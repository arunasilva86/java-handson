package com.learn.example.samplequestions;

import java.util.List;

public class MaxContiguousSum {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(5, -2, 15, -4, 6, 1, 9);
        System.out.println("Returned is : " + doSomething(integerList, 3));
    }

    public static long doSomething(List<Integer> pnl, int k) {

        // Write your code here
        long maxFound = 0;
        for (int count = 1; count <= k; count++) {
            long previousSum = 0;
            long currentSum = 0;
            int startIndex = 0;
            int endIndex = 0;
            for (int index = 0; index < pnl.size() - count; index++) {
                startIndex = index;
                endIndex = index + count - 1;
                if (startIndex == 0) {
                    currentSum = getSumOfRange(pnl, startIndex, endIndex);
                } else {
                    currentSum = previousSum - pnl.get(startIndex - 1) + pnl.get(endIndex);
                }
                if (currentSum > maxFound) {
                    maxFound = currentSum;
                }
                previousSum = currentSum;
            }
        }
        return maxFound;

    }

    private static long getSumOfRange(List<Integer> pnl, int start, int end) {
        long sum = 0;
        for (int x = start; x < pnl.size(); x++) {
            if (x >= start && x <= end) {
                sum = sum + pnl.get(x);
            }
            if (x > end) {
                return sum;
            }
        }
        return sum;

    }
}
