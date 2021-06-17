package com.company.lecture15;

import java.util.Arrays;

public class Sudoku_Backtracking {
    public static void main(String[] args) {
        int[][] sudoku = {  {5, 3, 0, 0, 7, 0, 0, 0, 0},
                            {6, 0, 0, 1, 9, 5, 0, 0, 0},
                            {0, 9, 8, 0, 0, 0, 0, 6, 0},
                            {8, 0, 0, 0, 6, 0, 0, 0, 3},
                            {4, 0, 0, 8, 0, 3, 0, 0, 1},
                            {7, 0, 0, 0, 2, 0, 0, 0, 6},
                            {0, 6, 0, 0, 0, 0, 2, 8, 0},
                            {0, 0, 0, 4, 1, 9, 0, 0, 5},
                            {0, 0, 0, 0, 8, 0, 0, 7, 9}  };
        solve(sudoku,0,0);

    }
    public static void solve(int[][] sudoku, int row, int col){
        if(row == 9){
            for(int[] rowSudoku : sudoku){
                System.out.println(Arrays.toString(rowSudoku));
            }
            return;
        }
        if(col == 9){
            solve(sudoku, row+1, 0);
            return;
        }
        if(sudoku[row][col] !=0) {
            solve(sudoku, row, col + 1);
        }else{
            for (int val = 1; val <= 9; val++) {
                if(isSafe(sudoku, row, col, val)){
                    sudoku[row][col] = val;
                    solve(sudoku, row, col+1);
                    sudoku[row][col] = 0;
                }
            }
        }

    }

    private static boolean isSafe(int[][] sudoku, int row, int col, int val) {
        for (int r = 0; r < 9; r++) {
            if(sudoku[r][col] == val){
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if(sudoku[row][c] == val){
                return false;
            }
        }
        int box_R = (row/3)*3;
        int box_C = (col/3)*3;
        for (int r = box_R; r < box_R+3; r++) {
            for (int c = box_C; c < box_C+3; c++) {
                if(sudoku[r][c] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
