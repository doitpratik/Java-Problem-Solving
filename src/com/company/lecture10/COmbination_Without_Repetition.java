package com.company.lecture10;

public class COmbination_Without_Repetition {
    public static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6};
        int target = 7;
        combination_Without_Repe(target, arr, 0,"", 0, 0);
        System.out.println("The no of count using combination without repetition : " + count);
    }
    private static void combination_Without_Repe(int target, int[] arr, int sum, String ans, int limit, int index){
        if(sum == target){
            System.out.println(ans);
            count++;
            return;
        }


        for (int i = index; i < arr.length; i++) {
            if(sum+arr[i] <= target){
                combination_Without_Repe(target, arr,sum+arr[i], ans+arr[i], limit+1 ,  i+1);
            }
        }
    }
}
