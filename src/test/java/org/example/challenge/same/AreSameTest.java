package org.example.challenge.same;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreSameTest {

    @Test
    public void valid() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, AreSame.comp(a, b));
    }

    @Test
    public void invalid() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{1212, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(false, AreSame.comp(a, b));
    }

    @Test
    public void valid_with_negative() {
        int[] a = new int[]{0, -14, 191, 161, 19, 144, 195, 1};
        int[] b = new int[]{1, 0, 196, 36481, 25921, 361, 20736, 38025};
        assertEquals(true, AreSame.comp(a, b));
    }

}
