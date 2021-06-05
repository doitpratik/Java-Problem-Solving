package com.company.lecture12;

import java.util.Arrays;

public class knighttour_Backtracking {
    static int N = 8;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
        int[] xdirection_Move = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] ydirection_Move = {1, 2, 2, 1, -1, -2, -2, -1};
        //starting point of knight
        board[0][0] = 0;
        if(nQueens(0,0,1,board, xdirection_Move,ydirection_Move)){
            System.out.println(Arrays.deepToString(board));
        }else{
            System.out.println("No solution");
        }
    }

    private static boolean nQueens(int i, int j, int count, int[][] board, int[] xdire, int[] ydire) {
        if(count == N*N){ // base condition
            return true;
        }
        for (int k = 0; k < N ; k++) {
            int i_next = i + xdire[k];
            int j_next = j + ydire[k];
            if(isSafe(board,i_next, j_next)){
                board[i_next][j_next] = count;
                if(nQueens(i_next, j_next, count+1, board, xdire, ydire)){
                    return true;
                }else{
                    board[i_next][j_next] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        return (row >= 0 && row < N && col >= 0 && col < N && board[row][col]==-1 );
    }
}
