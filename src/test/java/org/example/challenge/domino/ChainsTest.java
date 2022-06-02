package org.example.challenge.domino;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

class ChainsTest {

    @Test
    void should_create_all_chain_with_min_size_as_two() {
        List<Tile> tiles = asList(Tile.of(3, 4), Tile.of(4, 6));

        List<Chain> chains = new Chains(tiles);

        assertThat(chains).containsExactlyInAnyOrder(
                Chain.of(Tile.of(3, 4), Tile.of(4, 6)),
                Chain.of(Tile.of(6, 4), Tile.of(4, 3))
        );
    }

    @Test
    void should_create_all_chain_with_match_in_same_position() {
        List<Tile> tiles = asList(Tile.of(3, 4), Tile.of(6, 4));

        List<Chain> chains = new Chains(tiles);

        assertThat(chains).containsExactlyInAnyOrder(
                Chain.of(Tile.of(3, 4), Tile.of(4, 6)),
                Chain.of(Tile.of(6, 4), Tile.of(4, 3))
        );
    }

    @Test
    void should_create_all_chain_with_almost_min_size() {
        List<Tile> tiles = asList(Tile.of(3, 4), Tile.of(6, 4), Tile.of(1, 6));

        List<Chain> chains = new Chains(tiles);

        assertThat(chains).containsExactlyInAnyOrder(
                Chain.of(Tile.of(3, 4), Tile.of(4, 6)),
                Chain.of(Tile.of(3, 4), Tile.of(4, 6), Tile.of(6, 1)),
                Chain.of(Tile.of(6, 4), Tile.of(4, 3)),
                Chain.of(Tile.of(4, 6), Tile.of(6, 1)),
                Chain.of(Tile.of(1, 6), Tile.of(6, 4)),
                Chain.of(Tile.of(1, 6), Tile.of(6, 4), Tile.of(4, 3))
        );
    }

    @Test
    void should_ignore_tiles_with_no_matching_values() {
        Tile noMatchingValues = Tile.of(1, 5);
        List<Tile> tiles = asList(Tile.of(3, 4), noMatchingValues, Tile.of(6, 4));

        Chains chains = new Chains(tiles);

        assertThat(chains).noneMatch(it -> it.contains(noMatchingValues));
    }

    @Test
    void should_get_max_weight_chain() {
        Chains chains = new Chains(Collections.emptyList()) {{
            add(Chain.of(Tile.of(3, 4), Tile.of(4, 6)));
            add(Chain.of(Tile.of(3, 4), Tile.of(4, 6), Tile.of(6,1)));
        }};

        assertThat(chains.stream().max(comparing(Chain::weight)).get()).isEqualTo(Chain.of(Tile.of(3, 4), Tile.of(4, 6), Tile.of(6,1)));
    }
}
