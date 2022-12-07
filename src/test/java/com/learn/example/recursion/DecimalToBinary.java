package com.learn.example.recursion;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(devideByTwo(1100, ""));
    }

    public static String devideByTwo (int number, String result) {

        if(number == 0) {
            return result;
        }
        result = number % 2 + result ;
        return devideByTwo(number / 2 , result);
    }
}
