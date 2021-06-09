package com.company.lecture14;

public class NthMagicNumber {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(magicNumber(n));
    }

    private static int magicNumber(int n) {
        int place = 5, result=0;
        while(n>0){
            if((n&1) == 1){
                result = result+place;
            }
            place *= 5;
            n = n>>1;
        }
        return result;
    }
}
