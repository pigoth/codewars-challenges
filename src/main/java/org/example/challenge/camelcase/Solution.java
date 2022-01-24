package org.example.challenge.camelcase;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

class Solution{

    public static final String DELIMITERS = "_|-";

    static String toCamelCase(String input){
        String[] words = input.split(DELIMITERS);
       return range(0, words.length)
                .mapToObj(position -> position == 0 ? words[position] : replaceWithFirstLetterUpper(words[position]))
                .collect(joining());
    }

    private static String replaceWithFirstLetterUpper(String words) {
        return words.substring(0, 1).toUpperCase() + words.substring(1);
    }
}
