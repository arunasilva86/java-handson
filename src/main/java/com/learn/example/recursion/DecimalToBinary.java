package com.learn.example.recursion;

public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 13;
        System.out.println("binary representation of " + number + " is " + devideByTwo(number, ""));
    }

    public static String devideByTwo (int number, String result) {

        if(number == 0) {
            return result;
        }
        result = number % 2 + result ;
        return devideByTwo(number / 2 , result);
    }
}
