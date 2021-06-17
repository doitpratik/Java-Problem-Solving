package com.company.lecture15;

import java.util.ArrayList;
import java.util.List;

public class combinations_sum {
    public static void main(String[] args) {
        int[] numbers = {2,3,6,7};
        int k=7;
        System.out.println(combinations(numbers,k));

    }

    private static List<List<Integer>> combinations(int[] n, int k) {
        List<List<Integer>> comb = new ArrayList<List<Integer>>();
        final_Combination(comb, new ArrayList<Integer>(),0,n, k);
        return comb;
    }

    private static void final_Combination(List<List<Integer>> comb, ArrayList<Integer> integers,int start, int[] n, int k) {
        if(k<0){
            return;
        }
        if(k == 0){
            comb.add(new ArrayList<Integer>(integers));
            return;
        }
        for (int i=start; i< n.length;i++) {
                integers.add(n[i]);
                final_Combination(comb, integers,i, n, k - n[i]);
                integers.remove(integers.size() - 1);
        }
    }
}
