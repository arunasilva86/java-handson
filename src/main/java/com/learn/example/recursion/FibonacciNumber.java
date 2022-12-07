package com.learn.example.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println("Fib number is : " + calculateFibonacciNumber(60));
    }

    public static int calculateFibonacciNumber (int fibNumberIndex) {
        if (fibNumberIndex == 0 || fibNumberIndex == 1) {
            return 1;
        }
        return calculateFibonacciNumber(fibNumberIndex -1) + calculateFibonacciNumber(fibNumberIndex-2);
    }
}
