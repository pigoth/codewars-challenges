package org.example.challenge.dominoes;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.IntStream;

public class Dominoes {

    private HashMap<String, Integer> chains = new HashMap<>();

    private Tail start;
    private List<Tail> tails;

    public static Dominoes of(Tail start, List<Tail> tails) {
        return new Dominoes(start, tails);
    }

    private Dominoes(Tail start, List<Tail> tails) {
        this.start = start;
        this.tails = tails;
    }

    public Integer max() {
        branchWeight(start, tails);
        branchWeight(start.reverse(), tails);
        return chains.values().isEmpty() ? 0 : chains.values().stream().max(Integer::compareTo).get();
    }

    private void branchWeight(Tail start, List<Tail> sequence) {
        Integer value = start.right();
        List<Tail> matched = sequence.stream()
                .map(tail -> {
                    if (tail.matchLeft(value)) return tail;
                    else if (tail.matchRight(value)) return tail.reverse();
                    else return null;
                })
                .filter(Objects::nonNull).toList();

        matched.forEach(it -> {
            chains.computeIfPresent(start.toString(), (key, current) -> value + current);
            chains.computeIfAbsent(start.toString(), (key) -> value);
            int indexToRemove = sequence.indexOf(it);
            var newTail = new ArrayList(sequence);
            newTail.remove(indexToRemove);
            branchWeight(it, newTail);
        });

    }
}

