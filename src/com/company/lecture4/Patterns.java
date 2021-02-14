package com.company.lecture4;

public class Patterns {
    public static void Base_pattern (int n) {
        int row = 0;
        while (row < n) {
            int col = 0;
            while (col < n) {
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
    public static void Uptriangle(int n){
        int row = 0;
        while(row < n){
            int col = 0;
            while(col <= row){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
    public static void Downtriangle(int n){
        int row = 0;
        while ( row < n){
            int col = 0;
            while(col < n-row){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
    public static void HalfDiamond(int n){
        int row = 0, rowmirror=0;
        while ( rowmirror < 2*n-1){
            int col = 0;
            while(col < n-row){
                System.out.print( (row+col+1)+" ");
                col++;
            }
            System.out.println();
            if(rowmirror < n-1){
                row++;
            }
            else {
                row--;
            }
            rowmirror++;
        }
    }
    public static void HalfDiamondno(int n){
        int row = 0, rowmirror=0;
        while ( rowmirror < 2*n-1){
            int col = 0;
            while(col < n-row){
                System.out.print( (row+col+1)+" ");
                col++;
            }
            System.out.println();
            if(rowmirror < n-1){
                row++;
            }
            else {
                row--;
            }
            rowmirror++;
        }
    }

    public static void main(String[] args) {
        Base_pattern(5);
        System.out.println();
        Uptriangle(6);
        System.out.println();
        Downtriangle(5);
        System.out.println();
        HalfDiamond(4);
    }


}
