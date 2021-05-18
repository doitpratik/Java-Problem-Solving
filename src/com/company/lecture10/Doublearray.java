package com.company.lecture10;

public class Doublearray {
    public static void main(String[] args) {
        int[][] sor = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 30;
        boolean b = search_matrix(sor,target);
        System.out.println(b);
    }

    private static boolean search_matrix(int[][] sor, int target) {
        if(sor.length< 1 || sor[0].length < 1){
            return false;
        }
        int start = 0, end = sor.length-1;
        while( start>=0 && end >=0 && start < sor.length && end < sor[0].length){
            if(sor[start][end] == target) {
                return true;
            }else if(sor[start][end] > target){
                end--;
            }
            else{
                start++;
            }
        }
        return false;
    }
}
