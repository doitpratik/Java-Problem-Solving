package com.company;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr ={9,8,7,6,5,4,3,2,1};
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclic(int[] arr) {
        int i = 0;
        while(i <= arr.length-1){
            if(arr[i]-1 != i){
                swap(arr, i, arr[i]-1);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
