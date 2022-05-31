package org.example.challenge.dominoes;

import java.util.List;

public class Dominoes {
    public static Dominoes of(List<Tail> tails) {
        return new Dominoes(tails);
    }

    private List<Tail> tails;

    private Dominoes(List<Tail> tails) {
        this.tails = tails;
    }

    public Integer max() {
        return 0;
    }
}

