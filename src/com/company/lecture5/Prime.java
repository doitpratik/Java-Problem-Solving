package com.company.lecture5;
/* This Code for finding the given number is prime or not is most optimised for single input but in case
* of large inputs this is not optimized code instead of this sieve of eratothenes is most optimized code */
public class Prime {
    public static void main(String[] args) {
        int num = 100;
        System.out.println(primefn(num));
    }

    private static boolean primefn(int num) {
        for(int i=2; i*i < num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

}
