package org.example.challenge.tribonacci.sequence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XbonacciTest {
    private Xbonacci variabonacci;

    @BeforeEach
    public void setUp() {
        variabonacci = new Xbonacci();
    }

    @AfterEach
    public void tearDown() {
        variabonacci = null;
    }

    private double precision = 1e-10;

    @Test
    public void sampleTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, variabonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, variabonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, variabonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{19, 10 }, variabonacci.tribonacci(new double[]{19.0, 10.0, 5.0}, 2), precision);
    }

    @Test
    void should_return_empty_array_with_0_size() {
        assertArrayEquals(new double[]{}, variabonacci.tribonacci(new double[]{1, 1, 1}, 0), precision);
    }
}
