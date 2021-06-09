package com.company.lecture14;

public class UniqueII {
    public static void main(String[] args) {
        int[] nums = {2,10,4,7,2,4,6,6};
        uniqueII(nums);
    }

    private static void uniqueII(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        int ans1 = res,pos=0;
        while((ans1 & 1)!=1){
            pos++;
            ans1 = ans1>>1;
        }
        int mask = 1 << pos, first =0, second;
        for (int i :nums) {
            if((i & mask) >= 1){
                first = first^i;
            }
        }
        second = res^first;
        System.out.println(first + " : " + second);
    }
}
