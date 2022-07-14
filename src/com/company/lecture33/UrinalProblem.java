package com.company.lecture33;

import java.util.Scanner;

public class UrinalProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.close();
        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = 0;
            }
            solve(n, k, a);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i]);
            }
        }
        //sc.close();
    }

    private static void solve(int n, int k, int[] a) {
        for(int person = 1; person <= k; person++){
            int last = 0, len = 0, first = 0;
            for(int j = 0; j < n; j++){
                if(a[j] == 0){
                    len++;
                }
                if(a[j] == 1){
                    len = 0;
                }

                if(len >= first){
                    last = j;
                    first = len;
                }
            }

            int s = last-first+1;
            int mid = (s+last)/2;
            a[mid] = 1;
        }
        return ;
    }
}
