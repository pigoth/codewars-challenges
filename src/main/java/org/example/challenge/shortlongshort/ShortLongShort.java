package org.example.challenge.shortlongshort;

public class ShortLongShort {
    public static String solution(String a, String b) {
        return a.length() > b.length() ? resultFrom(a, b) : resultFrom(b, a);
    }

    private static String resultFrom(String shorterString, String longestString) {
        return longestString + shorterString + longestString;
    }
}
