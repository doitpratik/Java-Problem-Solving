package com.company.lecture10;

public class Combination_Repetition {
    public static int count = 0;
    public static void main(String[] args) {
        // Solving the question on combination with repetition
        // using recursion
        int[] arr = {1, 2, 5, 6};
        int  target = 7;
        combination_Repe(target, arr, 0, "", 0, 0);
        System.out.println("Total number of Combinations with repetition : " + count);
    }
    private static void combination_Repe(int target, int[] arr, int sum, String ans, int limit, int index){
        if(sum == target){
            System.out.println(ans);
            count++;
            return;
        }


        for (int i = index; i < arr.length; i++) {
            if(sum+arr[i] <= target){
                combination_Repe(target, arr,sum+arr[i], ans+arr[i], limit+1 ,  i);
            }
        }
    }
}
