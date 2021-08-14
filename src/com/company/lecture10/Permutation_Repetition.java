package com.company.lecture10;

public class Permutation_Repetition {
    public static int count = 0;
    public static void main(String[] args) {
        // Solving question Permutation with
        // Repetition using Recursion
        int[] arr = {1, 2, 6, 5};
        int target = 7;
        permu_repe(target, arr, 0, "", 0);
        System.out.println(count + "Total number of ways");
    }
    private static void permu_repe(int target, int[] arr, int sum , String ans, int limit){
        if(sum == target){
            System.out.println(ans);
            count++;
            return;
        }if(limit >= 4){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(sum+arr[i] <= target){
                permu_repe(target, arr,sum+arr[i], ans+arr[i], limit+1);
            }
        }
    }
}
