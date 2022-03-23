package com.company.sliding_window;

public class MaxSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,10,8,1,4};
        int size = 3;

        int max_sum = 0;

        for(int i = 0; i < size ; i++){
            max_sum += arr[i];
        }
        int sum = max_sum;
        for(int j = size; j < arr.length; j++){
            sum += arr[j] - arr[j-size];
            max_sum = Math.max(max_sum, sum);
        }

        System.out.println(max_sum);
    }
}
