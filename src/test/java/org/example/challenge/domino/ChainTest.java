package org.example.challenge.domino;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.example.challenge.domino.Chain.of;

class ChainTest {

    @Test
    void should_calculate_weight_as_the_sum_of_matching_values() {
        assertThat(of(Tile.of(1, 2), Tile.of(2, 1)).weight()).isEqualTo(2);
    }

    @Test
    void should_append_a_tile_in_my_chain() {
        Chain chain = Chain.empty()
                .append(Tile.of(1, 2))
                .append(Tile.of(2, 1));

        assertThat(chain).isEqualTo(Chain.of(Tile.of(1, 2), Tile.of(2, 1)));
    }

    @Test
    void should_not_append_no_matching_tile() {
        assertThatThrownBy(() ->
                Chain.empty()
                        .append(Tile.of(1, 2))
                        .append(Tile.of(5, 1))
        )
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void should_not_create_a_chain_with_not_valid_match() {
        assertThatThrownBy(() -> Chain.of(Tile.of(1, 2), Tile.of(5, 1)))
                .isInstanceOf(RuntimeException.class);
    }
}
