package com.learn.example.samplequestions;

/*
* Problem
The Gold price on each day is given in an array A[] of size N. Find the maximum profit you can make by purchasing and selling the gold on some days.

Note that if you have chosen to purchase the gold on the day i and sell it on day j then you can't purchase the gold again before the jth day.

Note: Profit is calculated as (Selling Price-Cost Price)

INPUT: First line of the input contains an integer T, denoting the number of test cases, first line of each test case contains an integer N, the next line of the test case contains N space separated integers, the elements of the array.

OUTPUT: For each test case print a single line containg the maximum value of Profit.

CONSTRAINTS:

1 < T < 100
2 < N < 103
0 < Ai < 104

Sample Input:
1
7
100 180 260 310 40 535 695
Sample Output:
865

* */
import java.util.Scanner;

public class GoldSeller {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      while (T-- > 0) {
        int N = sc.nextInt();
        int profit = 0;
        int prev = sc.nextInt();
        for (int i = 1; i < N; i++) {
          int curr = sc.nextInt();
          if (curr > prev) {
            profit += curr - prev;
          }
          prev = curr;
        }
        System.out.println(profit);
      }
      sc.close();
    }
}
