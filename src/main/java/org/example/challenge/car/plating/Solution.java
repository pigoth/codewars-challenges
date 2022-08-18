package org.example.challenge.car.plating;

import java.util.stream.Stream;

public class Solution {
    public static String findTheNumberPlate(int customerID) {
        int value = customerID + 1;

        return "aaa" + "0".repeat (3 - String.valueOf(value).length()) + value;
    }
}
