package com.company.lecture33;

import java.util.Scanner;

public class SpaceshipandCoins {
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(ans);
        int rows = sc.nextInt();
        int[][] board = new int [rows][5];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int isRowSafe = 0;
        getMaxCoins(board, isRowSafe, board.length-1, 1, false, 0);
        getMaxCoins(board, isRowSafe, board.length-1, 2, false, 0);
        getMaxCoins(board, isRowSafe, board.length-1, 3, false, 0);
        System.out.println(ans);
    }

    private static void getMaxCoins(int[][] board, int isRowSafe, int cur_row, int cur_col, boolean bomb, int coins) {
        if(cur_row < 0 || cur_col >= 5 || cur_col < 0){
            ans = Math.max(ans, coins);
            return ;
        }

        if(board[cur_row][cur_col] == 1 || board[cur_row][cur_col] == 0){
            int new_coins = coins;
            if(board[cur_row][cur_col] == 1){
                new_coins++;
            }
            if(bomb){
                isRowSafe--;
            }
            callMethods(board,isRowSafe, cur_row, cur_col, bomb, new_coins);
        }else if(board[cur_row][cur_col] == 2){
            if(bomb && isRowSafe <= 0){
                ans = Math.max(ans, coins);
                return ;
            }else if(bomb && isRowSafe > 0){
                isRowSafe--;
                callMethods(board,isRowSafe, cur_row, cur_col, bomb, coins);
            }else{
                bomb = true;
                isRowSafe = 4;
                callMethods(board,isRowSafe, cur_row, cur_col, bomb, coins);
            }
        }
    }

    private static void callMethods(int[][] board, int isRowSafe, int curr_row, int curr_col, boolean bomb, int coins) {
        getMaxCoins(board, isRowSafe, curr_row-1, curr_col, bomb, coins);
        getMaxCoins(board, isRowSafe, curr_row-1, curr_col+1, bomb, coins);
        getMaxCoins(board, isRowSafe, curr_row-1, curr_col-1, bomb, coins);
    }
}
