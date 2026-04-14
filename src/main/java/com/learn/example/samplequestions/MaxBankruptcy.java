package com.learn.example.samplequestions;

import java.util.Arrays;
import java.util.List;

/*
    A finance company is carrying out a study on the worst stock investments and would like to acquire a program to do so.
    The program must be able to analyze a chronological series of stock values in order to show the largest loss that it is possible to make by buying a share at a given time and selling it at a later date.
    The loss will be expressed as the difference between the two values. If there is no loss, it will be considered 0.

    You will receive a list as input, containing the stock values arranged in order, from the date of their introduction to the last known value. The values are integers.
    You must return the maximal loss p, expressed negatively if there is a loss, otherwise 0.
    The list can be of significant size (up to 100000 elements). Each value is an integer between 0 and 2^31.

    Example
            stock_prices = (3, 2, 4, 2, 1, 5)
    The function must return -3.
*/
public class MaxBankruptcy {
    public static void main(String[] args) {

        List<Integer> stockPrices = Arrays.asList(3, 2, 4, 2, 1, 5);
        int maxSoFar = stockPrices.get(0);
        int maxLost = 0;

        for (int index = 1; index < stockPrices.size(); index++) {

            int current = stockPrices.get(index);
            int lost = current - maxSoFar;

            if (current > maxSoFar) {
                maxSoFar = current;
            }

            if (lost < maxLost) {
                maxLost = lost;
            }

        }
        System.out.println("Max lost is : " + maxLost);

    }


}
