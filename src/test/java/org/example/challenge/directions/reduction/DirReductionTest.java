package org.example.challenge.directions.reduction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirReductionTest {

    @Test
    void remove_near_est_west() {
        String[] input = new String[]{"EAST", "WEST", "NORTH"};
        assertThat(DirReduction.dirReduc(input)).containsExactly("NORTH");
    }

    @Test
    void remove_near_west_est() {
        String[] input = new String[]{"NORTH", "WEST", "EAST"};
        assertThat(DirReduction.dirReduc(input)).containsExactly("NORTH");
    }

    @Test
    void remove_near_north_south() {
        String[] input = new String[]{"EAST", "NORTH", "SOUTH"};
        assertThat(DirReduction.dirReduc(input)).containsExactly("EAST");
    }

    @Test
    void remove_near_south_north() {
        String[] input = new String[]{"NORTH", "SOUTH", "EAST"};
        assertThat(DirReduction.dirReduc(input)).containsExactly("EAST");
    }

    @Test
    void remove_nearest_couple_more_than_once_time() {
        String[] input = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        assertThat(DirReduction.dirReduc(input)).containsExactly("WEST");
    }
}
