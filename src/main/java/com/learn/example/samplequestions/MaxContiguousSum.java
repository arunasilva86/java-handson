package com.learn.example.samplequestions;

import java.util.List;

/*
 * Find the max sum of the n consecutive values of a given array where n can be any integer value less than or equals a given integer k
 *
 * Ex 1 : {5, -2, 15, -4, 9, 1} and k = 3 then max sum is 20, as (15 + (-4) + 9) = 20 // max gives at n=3, (=k)
 * Ex 2 : {-1, -1, -1, 200, 300, -1, -1} and k = 4 then max sum is 500, as (200 + 300) = 500 // max gives at n=2, (<k)
 */
public class MaxContiguousSum {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(5, -2, 15, -4, 9, 1);
        System.out.println("Returned is : " + getMaxContiguousSum(integerList, 3));
    }

    public static long getMaxContiguousSum(List<Integer> pnl, int k) {

        long maxFound = 0;
        for (int count = 1; count <= k; count++) {
            long previousSum = 0;
            long currentSum = 0;
            int startIndex = 0;
            int endIndex = 0;
            for (int index = 0; index < pnl.size() - count + 1; index++) {
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
        for (int x = start; x <= end; x++) {
            sum = sum + pnl.get(x);
        }
        return sum;
    }
}
