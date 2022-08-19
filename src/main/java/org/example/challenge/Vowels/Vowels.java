package org.example.challenge.Vowels;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Vowels {
    public static int getCount(String abracadabra) {
        var vowels = "aeiou";
        return Arrays.stream(abracadabra.split(""))
                .filter(it -> vowels.contains(it))
                .collect(Collectors.joining())
                .length();
    }
}
