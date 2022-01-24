package org.example.challenge.abbreviator;

import java.util.Optional;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class Abbreviator {

    public String abbreviate(String string) {
        return stream(string.split(" "))
                .map(this::abbreviateSingleWord)
                .collect(joining(" "));
    }

    private String abbreviateSingleWord(String string) {
        return specialCharPosition(string)
                .map(compositeWordAbbreviate(string))
                .orElseGet(() -> abbreviateSingle(string));
    }

    private Function<Integer, String> compositeWordAbbreviate(String string) {
        return position -> abbreviateSingle(string.substring(0, position))
                + string.charAt(position)
                + abbreviateSingleWord(string.substring(position + 1));
    }

    private Optional<Integer> specialCharPosition(String string) {
        return range(0, string.length())
                .filter(position -> !Character.isLetter(string.charAt(position)))
                .boxed()
                .findFirst();
    }

    private String abbreviateSingle(String string) {
        if (string.length() <= 3) return string;
        return string.substring(0, 1) + (string.length() - 2) + string.substring(string.length() - 1);
    }

}
