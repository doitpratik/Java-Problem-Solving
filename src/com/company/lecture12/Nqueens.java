package com.company.lecture12;

public class Nqueens {
    public static void main(String[] args) {
        int N = 5;
        int[][] board= new int[N][N];
        //System.out.println(Arrays.deepToString(board));
        int count = 0;
        System.out.println(n_Queens(board, 0));
    }

    private static int n_Queens(int[][] board, int row) {
        if(row == board.length){
            //System.out.println(Arrays.deepToString(board));
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
          if(issafe(board, row, col)) {
              board[row][col] = 1;
              count += n_Queens(board, row + 1);
              board[row][col] = 0;
          }
        }
        return count;
    }

    private static boolean issafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 1){
                return  false;
            }
        }
        int leftdiagonal = Math.min(row, col);
        for (int i = leftdiagonal; i > 0; i--) {
            if(board[row-i][col-i] == 1){
                return false;
            }
        }
        int rightdiagonal = Math.min(row, board[0].length-1-col);
        for (int i = 1; i <= rightdiagonal; i++) {
            if(board[row-i][col+i] == 1){
                return false;
            }
        }
        return true;
    }
}
