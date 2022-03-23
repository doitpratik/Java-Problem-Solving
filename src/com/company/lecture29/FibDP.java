package com.company.lecture29;

public class FibDP {
    public static void main(String[] args) {
        int n = 30;
        Integer[] dp = new Integer[n+1];
        //fib(n, dp);
        System.out.println(tabDp(n, dp));

    }

    private static int fib(int i, Integer[] dp) {
        if(i <= 1){
            dp[i] = i;
            return i;
        }if(dp[i] != null){
            return dp[i];
        }
        dp[i] = fib(i-1, dp) + fib(i-2, dp);
        return dp[i];
    }
    private static int tabDp(int n, Integer[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int  i =2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }
}
