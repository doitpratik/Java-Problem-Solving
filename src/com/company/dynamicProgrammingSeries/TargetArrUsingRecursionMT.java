package com.company.dynamicProgrammingSeries;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TargetArrUsingRecursionMT {
    public static void main(String[] args) {
        int[]arr = {1, 4, 3, 2, 5, 6};
        int target = 10;
        /*
        long start1 = System.currentTimeMillis();
        System.out.println(permutationWithRecursion(arr, target));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);*/
        /*
        System.out.println("______Using Memoization_____");
        int[] dp = new int[target+1];
        long start = System.currentTimeMillis();
        System.out.println(permutationWithMemoization(arr, target, dp));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        */

        System.out.println("______Using Tabulation_____");
        int[] dp = new int[target+1];
        long start = System.currentTimeMillis();
        System.out.println(permutationWithTabulation(arr, dp));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Arrays.toString(dp));

    }

    private static int permutationWithTabulation(int[] arr, int[] dp) {
/*        for (int i = 0; i <= target; i++) {
            if(i == 0){
                dp[i] = 1;
                continue;
            }
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(i-arr[j] >= 0){
                    count += dp[i-arr[j]];
                }
            }
            dp[i] = count;
        }
        return dp[dp.length-1];*/

        for(int target = 0; target<dp.length; target++){
            if(target == 0){
              dp[target] =1;
              continue;
            }
            int count = 0;
            for (int i = 0; i < arr.length ; i++) {
                if(target-arr[i] >= 0){
                    count += dp[target-arr[i]];
                }
            }
            dp[target] = count;
        }
        return dp[dp.length-1];
    }

    private static int permutationWithMemoization(int[] arr, int target, int[] dp) {
        if(target == 0){
            return dp[target] =1;
        }
        if(dp[target]!=0){
            return dp[target];
        }
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(target-arr[i] >= 0){
                count += permutationWithMemoization(arr, target-arr[i], dp);
            }
        }
        return dp[target] = count;
    }

    private static int permutationWithRecursion(int[] arr, int target) {
        if(target == 0){
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(target-arr[i] >= 0){
                count += permutationWithRecursion(arr, target-arr[i]);
            }
        }
        return count;
    }
}
