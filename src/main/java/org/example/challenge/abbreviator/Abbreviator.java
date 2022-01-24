package org.example.challenge.abbreviator;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Abbreviator {

    public String abbreviate(String string) {
        return stream(string.split(" "))
                .map(this::abbreviateSingleWord)
                .collect(Collectors.joining(" "));
    }

    private String abbreviateSingleWord(String string) {
        Optional<Integer> specialCharPosition = IntStream.range(0, string.length())
                .filter(position -> !Character.isLetter(string.charAt(position)))
                .mapToObj(it -> Integer.valueOf(it))
                .findFirst();

        if (specialCharPosition.isPresent()) {
            return abbreviateSingle(string.substring(0, specialCharPosition.get()))
                    + string.charAt(specialCharPosition.get())
                    + abbreviateSingleWord(string.substring(specialCharPosition.get() +1));
        } else {
            return abbreviateSingle(string);
        }

    }

    private String abbreviateSingle(String string) {
        if (string.length() <= 3) return string;

        return string.substring(0, 1) + (string.length() - 2) + string.substring(string.length() - 1);
    }

}
