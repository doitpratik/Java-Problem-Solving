package com.company.lecture4;

public class Dumbell {
    public static void dumb(int n){
        int row =0,rowmirror=0;
        while(rowmirror< 2*n-1){
            int col=0,colmirror=0;
            while(colmirror< 6*n-3){
                if(((col+row)<n-1) || ((col >2*n-2) && (row < n/2))){
                    System.out.print("  ");
                }
                else {
                    System.out.print("* ");
                }
                if(colmirror < 3*n-2) {
                    col++;
                }else{
                    col--;
                }
                colmirror++;
            }

            System.out.println();
            if(rowmirror < n-1){
                row++;
            }else{
                row--;
            }
            rowmirror++;
        }
    }

    public static void chess(int n){
        int row = 0;
        while(row < n){
            int col=0;
            int colmix=0;
            while(col < n){
                if((col+row)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
                col++;
            }
            System.out.println();
            row++;
        }
    }
    public static void main(String[] args) {
        //dumb(5);
        chess(8);
    }
}
