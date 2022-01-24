package org.example.challenge.abbreviator;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Abbreviator {

    public String abbreviate(String string) {
        return stream(string.split(" "))
                .map(this::abbreviateSingleWord)
                .collect(Collectors.joining(" "));
    }

    private String abbreviateSingleWord(String string) {
        return string.length() <= 3 ?
                string :
                string.substring(0, 1) + (string.length() - 2) + string.substring(string.length() - 1);
    }

}
