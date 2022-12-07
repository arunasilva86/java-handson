package com.learn.example.debugs;

public class TetsOne {

    public static void main(String[] args) {
        biggerIsGreater("zypag");
    }

    public static String biggerIsGreater(String w) {

        // Write your code here
        String result = "";
        for (int i = w.length() -1; i > 0 ; i--) {
            if ((char)w.charAt(i) > (char)w.charAt(i-1)) {
                String subString = w.substring(i-1);
                String finalSubString = arrangeSubString(subString);

                if (i > 1) {
                    result =  w.substring(0, i-1) + finalSubString;
                } else {
                    result =  finalSubString;
                }
                System.out.println(result);
                return result;

            }
        }

        result =  "Can not found a matching String ... ";
        System.out.println(result);
        return result;
    }

    public static String arrangeSubString (String s) {
        StringBuilder sb = new StringBuilder(s);
        char firstChar = (char)sb.charAt(0);
        char currentMaxChar = 'z';
        int index = 0;
        for (int i = 1; i < sb.length(); i++) {
            if ((char)sb.charAt(i) > firstChar && (char)sb.charAt(i) < currentMaxChar) {
                currentMaxChar = (char)sb.charAt(i);
                index = i;
            }
        }
        String afterRemoveChar = sb.deleteCharAt(index).toString();

        String sorted = afterRemoveChar.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        // Arrays.sort(afterRemoveChar.toCharArray());
        String finalSubString = currentMaxChar + sorted;
        return finalSubString;

    }
}
