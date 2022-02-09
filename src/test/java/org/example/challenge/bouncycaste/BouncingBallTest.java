package org.example.challenge.bouncycaste;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BouncingBallTest {

    @Test
    void should_return_negative_is_h_is_less_or_equal_zero() {
        assertThat(BouncingBall.bouncingBall(0, 0, 0)).isEqualTo(-1);
    }

    @Test
    public void test1() {
        assertEquals(3, BouncingBall.bouncingBall(3.0, 0.66, 1.5));
    }
    @Test
    public void test2() {
        assertEquals(15, BouncingBall.bouncingBall(30.0, 0.66, 1.5));
    }
}
