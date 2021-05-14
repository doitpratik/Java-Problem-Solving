package com.company.lecture10;

public class Recurrsion_Continuation {
    private static void pattern_recurrsion(int row, int col){
        if(row == 0){
            return ;
        }
        if(row == col){
            pattern_recurrsion(row-1, 0);
            System.out.println();
            return ;
        }

        pattern_recurrsion(row,col+1);
        System.out.print("* ");
    }
    private static void pattern_recurrsion_rowwise(int row, int col){
        if(row == 0){
            return ;
        }
        if(row == col){
            System.out.println();
            pattern_recurrsion_rowwise(row-1, 0);
            return ;
        }
        System.out.print("* ");
        pattern_recurrsion_rowwise(row,col+1);
    }
    public static void main(String[] args) {
        int row = 5, col=0;

        pattern_recurrsion(row, col);
    }
}
