package org.example.challenge.domino;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.challenge.domino.Chain.of;

class ChainTest {

    @Test
    void should_calculate_weight_as_the_sum_of_matching_values() {
        assertThat(of(Tile.of(1,2), Tile.of(2,1)).weight()).isEqualTo(2);
    }


}
