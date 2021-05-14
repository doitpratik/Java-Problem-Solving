package com.company.lecture10;

public class Recursion_Problemsolving {
    public static void main(String[] args) {
        int[] a = {2,9,1,3,0,4};
        boolean c = isSorted(a,a.length);
        System.out.println(c);
    }

    private static boolean isSorted(int[] a, int length) {
        if(length==1 || length ==0){
            return true;
        }
        if(a[length-1] < a[length-2]){
             return false;
         }
         return isSorted(a, length-1);
    }
}
