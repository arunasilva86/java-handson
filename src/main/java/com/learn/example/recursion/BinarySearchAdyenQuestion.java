package com.learn.example.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchAdyenQuestion {

    public static void main(String[] args) {
        List<BinRange> binRangeList = new ArrayList(List.of(
                new BinRange(900, 1000, "Mestro"),
                new BinRange(300, 400, "MasterCard"),
                new BinRange(100, 200, "VISA"),
                new BinRange(600, 700, "AMEX"),
                new BinRange(1100, 1200, "OTHER"))
                );
        Collections.sort(binRangeList, (binRange1, binRange2) -> Integer.valueOf(binRange1.getStart()).compareTo(Integer.valueOf(binRange2.getStart())));

        BinRange binRange = binRangeBinarySearch(320, binRangeList, 0, binRangeList.size() -1);
        if (binRange != null) {
            System.out.println("Found the matching card type as : " + binRange.getCardType());
        } else {
            System.out.println("No matching card found for the given Bin range...");
        }
    }


    public static BinRange binRangeBinarySearch (int cardNumberLastDigits, List<BinRange> binRangeList, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex)/2;
        BinRange midElement = binRangeList.get(midIndex);
        BinRange matchingBinRange = null;
        if (midElement.getStart() <= cardNumberLastDigits && cardNumberLastDigits <= midElement.getEnd()) {
            matchingBinRange = midElement;
        } else if (startIndex == endIndex) {
            return null;
        } else if (cardNumberLastDigits < midElement.getStart()) {
            matchingBinRange = binRangeBinarySearch(cardNumberLastDigits, binRangeList, startIndex, midIndex -1);
        } else if (midElement.getEnd() <  cardNumberLastDigits) {
            matchingBinRange= binRangeBinarySearch(cardNumberLastDigits, binRangeList, midIndex + 1, endIndex);
        }
        return matchingBinRange;
    }

}

class BinRange {

    private int start;
    private int end;
    private String cardType;

    public BinRange(int start, int end, String cardType) {
        this.start = start;
        this.end = end;
        this.cardType = cardType;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getCardType() {
        return cardType;
    }
}
