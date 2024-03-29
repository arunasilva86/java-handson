package com.learn.example.samplequestions;


/*
* For a given positive integer, N
* find the smallest integer grater than N which does not contain same digit in adjacent
*
* Eg 1 : if N = 276 then the result is : 278
* Eg 2 : if N = 109 then the result is : 120
* Eg 3 : if N = 1111111 then the result is : 1201010
* Eg 4 : if N = 522199563 then the result is : 523010101 *
*/
public class NextMaxIntWithNoSameInAdjacent {
    public static void main(String[] args) {

        int n = 522199563; // 523010101
        System.out.println("Value is :" + minNumberWithNoCons(n));
    }

    private static int minNumberWithNoCons (int N) {
        StringBuilder sb = new StringBuilder(String.valueOf(N));
        Character previousChar = Character.MIN_VALUE ;
        for (int index = 0; index < sb.length(); index++) {
            if (sb.charAt(index) == previousChar.charValue()) {
                String leftInt = String.valueOf(Integer.valueOf(sb.substring(0, index + 1)) + 1);
                String rightString = swapWithZeroAndOne(sb.substring(index + 1));
                String finalString = leftInt.concat(rightString);
                return Integer.valueOf(finalString);
            }
            previousChar = sb.charAt(index);
        }
        return minNumberWithNoCons(N + 1);
    }

    private static String swapWithZeroAndOne (String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int x = 0; x < sb.length(); x++) {
            if (x%2 == 0) {
                sb.setCharAt(x, '0');
            } else {
                sb.setCharAt(x, '1');
            }
        }
        return sb.toString();
    }



}
