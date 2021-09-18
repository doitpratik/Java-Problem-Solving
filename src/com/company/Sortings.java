package com.company;

import java.util.Arrays;

public class Sortings {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1};
        /*bubbling_sort(arr);
        System.out.println(Arrays.toString(arr));*/
        System.out.println(jump(arr));
    }
    public static void bubbling_sort(int[] arrai){
        for(int i = 0; i< arrai.length-1; i++){
            for (int j = 0; j < arrai.length-i-1 ; j++) {
                if(arrai[j] > arrai[j+1]){
                    swap(arrai,j,j+1);
                }
                else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] arrai, int j, int j2) {
        int temp = arrai[j];
        arrai[j] = arrai[j2];
        arrai[j2] = temp;

    }
    public static int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int i = 0, maxReach = 0, count=0;
        while(i < nums.length && i <= maxReach){
            if(nums[i] > 0){
                count++;
                maxReach = Math.max(i+nums[i], maxReach);
            }
            if(maxReach >= nums.length-1){
                return count;
            }

            i++;
        }
        return 0;
    }
}
