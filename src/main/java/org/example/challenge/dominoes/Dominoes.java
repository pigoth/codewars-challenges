package org.example.challenge.dominoes;

import java.util.*;

public class Dominoes {

    private HashMap<String, Integer> chains = new HashMap<>();

    private TailNOOOOO start;
    private List<TailNOOOOO> tails;

    public static Dominoes of(TailNOOOOO start, List<TailNOOOOO> tails) {
        return new Dominoes(start, tails);
    }

    private Dominoes(TailNOOOOO start, List<TailNOOOOO> tails) {
        this.start = start;
        this.tails = tails;
    }

    public Integer max() {
        branchWeight(start, tails);
        branchWeight(start.reverse(), tails);
        return chains.values().isEmpty() ? 0 : chains.values().stream().max(Integer::compareTo).get();
    }

    private void branchWeight(TailNOOOOO start, List<TailNOOOOO> sequence) {
        Integer value = start.right();
        List<TailNOOOOO> matched = sequence.stream()
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

