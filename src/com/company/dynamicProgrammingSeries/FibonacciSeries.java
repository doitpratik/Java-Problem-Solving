package com.company.dynamicProgrammingSeries;

import java.util.Arrays;

public class FibonacciSeries {
    public static void main(String[] args) {
        int num = 50;
        /*
        long start = System.currentTimeMillis();
        System.out.println(fibonacci_Recursion(num));
        long end  = System.currentTimeMillis();
        System.out.println(end-start);*/

        /* Memoization
        int[] dp = new int[num+1];
        long start = System.currentTimeMillis();
        System.out.println(fibo_memoization(num, dp));
        long end  = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(dp));
        */

        //Tabulation
        int[] dp = new int[num+1];
        long start = System.currentTimeMillis();
        System.out.println(fibo_tbaulation(num, dp));
        long end  = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(dp));
    }

    private static int fibo_tbaulation(int num, int[] dp) {
        for (int i = 0; i <= num ; i++) {
            if(i <= 1){
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[num];
    }

    private static int fibo_memoization(int num, int[] dp) {
        if(num <= 1){
            return dp[num] = num;
        }if(dp[num]!=0){
            return dp[num];
        }
        return dp[num] = fibo_memoization(num-1, dp) + fibo_memoization(num-2, dp);
    }

    private static int fibonacci_Recursion(int num) {
        if(num <= 1){
            return num;
        }
        return fibonacci_Recursion(num-1) + fibonacci_Recursion(num-2);
    }
}
