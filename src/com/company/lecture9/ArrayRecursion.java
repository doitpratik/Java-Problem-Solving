package com.company.lecture9;

public class ArrayRecursion {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int target = 5;
        int lin= linear_search(array,0, target);
        System.out.println(lin);
    }

    private static int linear_search(int[] array, int i, int target) {
        if(i == array.length){
            return -1;
        }
        if(array[i] == target){
            return i;
        }

        return linear_search(array,i+1,target);

    }
}
