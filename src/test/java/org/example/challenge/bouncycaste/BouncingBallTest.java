package org.example.challenge.bouncycaste;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BouncingBallTest {

    @Test
    void should_return_negative_is_h_is_less_or_equal_zero() {
        assertThat(BouncingBall.bouncingBall(0, 0, 0)).isEqualTo(-1);
    }

    @Test
    void should_return_negative_is_bounce_is_less_or_equal_zero() {
        assertThat(BouncingBall.bouncingBall(1, 0, 0)).isEqualTo(-1);
    }

    @Test
    void should_return_negative_is_bounce_is_greater_or_equal_one() {
        assertThat(BouncingBall.bouncingBall(1, 1, 0)).isEqualTo(-1);
    }

    @Test
    void should_return_negative_if_window_is_greater_or_equal_than_height() {
        assertThat(BouncingBall.bouncingBall(1, 0.9, 12)).isEqualTo(-1);
    }

    @Test
    public void test1() {
        assertEquals(3, BouncingBall.bouncingBall(3.0, 0.66, 1.5));
    }

}
