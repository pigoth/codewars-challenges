package org.example.challenge.domino;

import org.assertj.core.util.Arrays;
import org.example.challenge.dominoes.Tail;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AllTest {
    @Test
    void name() {
        Tile head = new Tile(4, 3);
        List<Tile> list = List.of(
                new Tile(4, 6),
                new Tile(1, 4),
                new Tile(4, 9),
                new Tile(10, 9),
                head,
                new Tile(5, 4),
                new Tile(1, 6),
                new Tile(4, 6)
        );

        All all = new All();
        all.listChains(new ArrayList<>(), new ArrayList<>(list));
        List<List<Tile>> result = all.allChain(head);

        assertThat(result).allMatch(it -> it.contains(head));
        assertThat(result).hasSize(42);

        result.forEach(System.out::println);

    }
}
