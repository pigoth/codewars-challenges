package org.example.challenge.domino;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

class ChainTest {

    @Test
    void should_create_all_chain_with_min_size_as_two() {
        List<Tile> tiles = of(new Tile(3, 4), new Tile(4, 6));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).containsExactlyInAnyOrder(
                of(new Tile(3, 4), new Tile(4, 6)),
                of(new Tile(6, 4), new Tile(4, 3))
        );
    }

    @Test
    void should_create_all_chain_with_match_in_same_position() {
        List<Tile> tiles = of(new Tile(3, 4), new Tile(6, 4));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).containsExactlyInAnyOrder(
                of(new Tile(3, 4), new Tile(4, 6)),
                of(new Tile(6, 4), new Tile(4, 3))
        );
    }


    @Test
    void should_create_all_chain_with_almost_min_size() {
        List<Tile> tiles = of(new Tile(3, 4), new Tile(6, 4), new Tile(1, 6));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).containsExactlyInAnyOrder(
                of(new Tile(3, 4), new Tile(4, 6)),
                of(new Tile(3, 4), new Tile(4, 6), new Tile(6, 1)),
                of(new Tile(6, 4), new Tile(4, 3)),
                of(new Tile(4, 6), new Tile(6, 1)),
                of(new Tile(1, 6), new Tile(6, 4)),
                of(new Tile(1, 6), new Tile(6, 4), new Tile(4, 3))
        );
    }

    @Test
    void should_ignore_tiles_with_no_matching_values() {
        Tile noMatchingValues = new Tile(1, 5);
        List<Tile> tiles = of(new Tile(3, 4), noMatchingValues, new Tile(6, 4));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).noneMatch(it -> it.contains(noMatchingValues));
    }

//    @Test
//    void name() {
//        Tile head = new Tile(4, 3);
//        List<Tile> list = List.of(
//                new Tile(4, 6),
//                new Tile(1, 4),
//                new Tile(4, 9),
//                new Tile(10, 9),
//                head,
//                new Tile(5, 4),
//                new Tile(1, 6),
//                new Tile(4, 6)
//        );
//
//        Chains chains = new Chains(list);
//        List<List<Tile>> result = chains.allWith(head);
//
//        assertThat(result).allMatch(it -> it.contains(head));
//        assertThat(result).hasSize(42);
//
//        result.forEach(System.out::println);
//
//    }
}
