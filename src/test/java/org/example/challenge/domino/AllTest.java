package org.example.challenge.domino;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AllTest {
    @Test
    void name() {
        List<Tile> list = new ArrayList<>();
        // [3/4] [5/6] [1/4] [1/6]
        Tile head = new Tile(4, 3);
        list.add(new Tile(4, 6));
        list.add(new Tile(1, 4));
        list.add(new Tile(4, 9));
        list.add(new Tile(10, 9));
        list.add(head);
        list.add(new Tile(5, 4));
        list.add(new Tile(1, 6));
        list.add(new Tile(4, 6));

        List<Tile> chain = new ArrayList<>();
        All all = new All();
        all.listChains(chain, list);
        List<List<Tile>> result = all.allChain(head);

        assertThat(result).allMatch(it -> it.contains(head));

        result.forEach(System.out::println);

    }
}
