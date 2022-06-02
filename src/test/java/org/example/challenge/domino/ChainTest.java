package org.example.challenge.domino;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

class ChainTest {

    @Test
    void should_create_all_chain_with_min_size_as_two() {
        List<Tile> tiles = asList(Tile.of(3, 4), Tile.of(4, 6));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).containsExactlyInAnyOrder(
                asList(Tile.of(3, 4), Tile.of(4, 6)),
                asList(Tile.of(6, 4), Tile.of(4, 3))
        );
    }

    @Test
    void should_create_all_chain_with_match_in_same_position() {
        List<Tile> tiles = asList(Tile.of(3, 4), Tile.of(6, 4));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).containsExactlyInAnyOrder(
                asList(Tile.of(3, 4), Tile.of(4, 6)),
                asList(Tile.of(6, 4), Tile.of(4, 3))
        );
    }


    @Test
    void should_create_all_chain_with_almost_min_size() {
        List<Tile> tiles = asList(Tile.of(3, 4), Tile.of(6, 4), Tile.of(1, 6));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).containsExactlyInAnyOrder(
                asList(Tile.of(3, 4), Tile.of(4, 6)),
                asList(Tile.of(3, 4), Tile.of(4, 6), Tile.of(6, 1)),
                asList(Tile.of(6, 4), Tile.of(4, 3)),
                asList(Tile.of(4, 6), Tile.of(6, 1)),
                asList(Tile.of(1, 6), Tile.of(6, 4)),
                asList(Tile.of(1, 6), Tile.of(6, 4), Tile.of(4, 3))
        );
    }

    @Test
    void should_ignore_tiles_with_no_matching_values() {
        Tile noMatchingValues = Tile.of(1, 5);
        List<Tile> tiles = asList(Tile.of(3, 4), noMatchingValues, Tile.of(6, 4));

        List<List<Tile>> result = new Chains(tiles).all(it -> true);

        assertThat(result).noneMatch(it -> it.contains(noMatchingValues));
    }

//    @Test
//    void name() {
//        Tile head = Tile.of(4, 3);
//        List<Tile> list = List.of(
//                Tile.of(4, 6),
//                Tile.of(1, 4),
//                Tile.of(4, 9),
//                Tile.of(10, 9),
//                head,
//                Tile.of(5, 4),
//                Tile.of(1, 6),
//                Tile.of(4, 6)
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
