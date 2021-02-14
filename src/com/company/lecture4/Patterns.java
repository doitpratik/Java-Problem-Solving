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
    public static void HalfDiamondInversecoloumn(int n){
        int row = 0, rowmirror=0;
        while ( row< n){
            int col = 0 ;
            int colmirror = 0;
            while(colmirror < 2*n-1){
                if(col < row){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
                if(colmirror < n-1){
                    col++;
                }else{
                    col--;
                }
                colmirror++;
            }
            System.out.println();
            /*if(rowmirror < n-1){
                row++;
            }
            else {
                row--;
            }*/
            row++;
        }
    }
    public static void HalfDiamondInverserow(int n){
        int row = 0, rowmirror=0;
        while ( rowmirror< 2*n-1){
            int col = 0 ;
            int colmirror = 0;
            while(col < n){
                if(col < row){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
                /*if(colmirror < n-1){
                    col++;
                }else{
                    col--;
                }
                colmirror++;*/
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
    public static void HalfDiamondInverse_columnwisemirroring(int n){
        int row = 0, rowmirror=0;
        while ( rowmirror< 2*n-1){
            int col = 0 ;
            int colmirror = 0;
            while(colmirror < 2*n-1){
                if(col < row){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
                if(colmirror < n-1){
                    col++;
                }else{
                    col--;
                }
                colmirror++;
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
    public static void Diamond(int n){
        int row = 0, rowmirror=0;
        while ( rowmirror< 2*n-1){
            int col = 0 ;
            int colmirror = 0;
            while(colmirror < 2*n-1){
                if((col+row) < n-1){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
                if(colmirror < n-1){
                    col++;
                }else{
                    col--;
                }
                colmirror++;
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
    public static void Diamondcutting(int n){
        int row = 0, rowmirror=0;
        while ( rowmirror< 2*n-1){
            int col = 0 ;
            int colmirror = 0;
            while(colmirror < 2*n-1){
                if((col+row) < n-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                if(colmirror < n-1){
                    col++;
                }else{
                    col--;
                }
                colmirror++;
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
    public static void HalfDiamondInverse_columnInvertedmirroring(int n){
        int row = 0, rowmirror=0;
        while ( row< n){
            int col = 0 ;
            int colmirror = 0;
            while(colmirror < 2*n-1){
                if(col < row){
                    System.out.print("* ");
                }
                else{
                    System.out.print(" ");
                }
                if(colmirror < n-1){
                    col++;
                }else{
                    col--;
                }
                colmirror++;
            }
            System.out.println();
            /*if(rowmirror < n-1){
                row++;
            }
            else {
                row--;
            }*/
            row++;
        }
    }


    public static void main(String[] args) {
        HalfDiamondInverse_columnInvertedmirroring(5);
    }


}
