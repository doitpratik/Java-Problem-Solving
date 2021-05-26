package com.company;

import java.util.Arrays;

public class Sortings {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubbling_sort(arr);
        System.out.println(Arrays.toString(arr));
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
}
