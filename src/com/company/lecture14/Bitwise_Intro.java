package com.company.lecture14;

public class Bitwise_Intro {
    public static void main(String[] args) {
        int num=16;
        // i have to write the function which tell me the num is odd or even using bitwise
        System.out.println(isOdd(num));
        int[] nums = {2,3,5,7,5,6,3,2,6};
        System.out.println(findUnique(nums));
        //int number = 11111111111111111111111111111101;
        //System.out.println(countbits(number));
    }

    private static int countbits(int number) {
        int count = 0;
        while(number > 0){
            if((number&1)==1){
                count++;
            }
            number >>= 1;
        }
        return count;
    }

    private static int findUnique(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }

    private static boolean isOdd(int num) {
        return (num&1)==1;
    }
}
