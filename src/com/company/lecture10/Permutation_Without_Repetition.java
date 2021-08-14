package com.company.lecture10;

import java.util.*;

public class Permutation_Without_Repetition {
    public static void main(String[] args) {
        int[] a ={1,2,3,4 };
        int index = 0;
        substring("", index,a);
    }

    private static void substring(String processed, int index,int[] a) {
        if(a.length  == index){
            System.out.println(processed);
            return ;
        }
        substring(processed, index+1,a);
        substring(processed+a[index]+" ", index+1, a);
    }
}
