package org.example.challenge.find.odd;

import java.util.Map;
import java.util.function.Predicate;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindOdd {
    public static int findIt(int[] a) {
        Predicate<Map.Entry<Integer, Long>> isOdd = it -> it.getValue() % 2 == 1;
        return stream(a).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .filter(isOdd)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }
}
