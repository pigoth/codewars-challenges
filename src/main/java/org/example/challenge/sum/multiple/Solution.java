package org.example.challenge.sum.multiple;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Solution {

    public int solution(int number) {
        IntPredicate isMultiple = value -> value % 3 == 0 || value % 5 == 0;
        return IntStream.range(0, number)
                .filter(isMultiple)
                .sum();
    }
}
