package org.example.challenge.sudoku;

import java.util.ArrayList;
import java.util.function.IntPredicate;

import static java.util.Arrays.stream;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        return rowsIsRight(sudoku) &&
                columnsIsRight(sudoku) &&
                isRight(region(sudoku, 0, 2, 0, 2)) &&
                isRight(region(sudoku, 3, 5, 0, 2)) &&
                isRight(region(sudoku, 6, 8, 0, 2)) &&

                isRight(region(sudoku, 0, 2, 3, 5)) &&
                isRight(region(sudoku, 3, 5, 3, 5)) &&
                isRight(region(sudoku, 6, 8, 3, 5)) &&

                isRight(region(sudoku, 0, 2, 6, 8)) &&
                isRight(region(sudoku, 3, 5, 6, 8)) &&
                isRight(region(sudoku, 6, 8, 6, 8));
    }

    private static boolean columnsIsRight(int[][] sudoku) {
        return stream(columnsAsRow(sudoku)).allMatch(it -> isRight(it));
    }

    private static boolean rowsIsRight(int[][] sudoku) {
        return stream(sudoku).allMatch(it -> isRight(it));
    }

    private static int[] region(int[][] sudoku, int startRowIndex, int endRowIndex, int startColumnIndex, int endColumnIndex) {
        ArrayList<Integer> region = new ArrayList<>();
        for (int i = startRowIndex; i <= endRowIndex; i++) {
            for (int j = startColumnIndex; j <= endColumnIndex; j++) {
                region.add(sudoku[i][j]);
            }
        }
        return region.stream().mapToInt(it ->it).toArray();
    }


    public static int[][] columnsAsRow(int[][] sudoku) {
        int[][] reverse = new int[sudoku.length][sudoku.length];
        for (int i = 0; i < sudoku.length; i++) {
            int[] column = new int[sudoku.length];
            for (int j = 0; j < sudoku.length; j++) {
                column[j] = sudoku[j][i];
            }
            reverse[i] = column;
        }
        return reverse;
    }

    private static boolean isRight(int[] row) {
        IntPredicate validValue = value -> value > 0 && value < 10;
        return stream(row).filter(validValue).distinct().count() == 9;
    }

}
