package org.example.challenge.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SudokuValidatorTest {

    private int[][] sudoku = new int[][]{
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    @Test
    public void right_case() {
        assertEquals(true, SudokuValidator.check(sudoku));
    }

    @Test
    public void invalid_case() {
        sudoku[0][0] = 6;
        assertEquals(false, SudokuValidator.check(sudoku));
    }

    @Test
    public void invalid_value() {
        sudoku[4][4] = 0;

        assertEquals(false, SudokuValidator.check(sudoku));
    }
}
