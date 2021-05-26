package com.company.lecture12;

import java.util.Arrays;
import java.util.Enumeration;

public class QuickSort {
    public static void main(String[] args) {
        int[] arrai = {6,3,0,1,4,7,2};
        int start=0,end =arrai.length-1;
        quick_Sort(arrai,start,end);
        System.out.println(Arrays.toString(arrai));
    }

    private static void quick_Sort(int[] arrai, int start, int end) {
        if(start >= end){
            return;
        }
        int pos = pivot(arrai,start,end);
        quick_Sort(arrai, start, pos-1);
        quick_Sort(arrai, pos+1, end);
    }

    private static int pivot(int[] arrai, int start, int end) {
        int ind = start;
        for (int i = start; i < end ; i++) {
            if(arrai[i] < arrai[end]){
                swap(arrai, ind,i);
                ind++;
            }
        }
        swap(arrai, ind, end);
        return ind;
    }

    private static void swap(int[] arrai, int ind, int i) {
        int t = arrai[ind];
        arrai[ind] = arrai[i];
        arrai[i] = t;
    }
}
