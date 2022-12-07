package com.learn.example.recursion;

public class NumberSum {
    public static void main(String[] args) {
        int sum = getSum(10, 0);
        System.out.println("Sum : " + sum);
    }

    public static int getSum (int number, int sum) {
        if (number == 0) {
            return sum;
        }
        sum = number + sum;
        return getSum(number - 1, sum);
    }
}
