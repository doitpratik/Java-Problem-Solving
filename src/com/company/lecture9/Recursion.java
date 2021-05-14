package com.company.lecture9;

import java.util.Locale;
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       /* String str = new String();
        str = sc.next();
        str = str.toLowerCase();
        boolean palindrome = palindrome(str);
        System.out.println(palindrome);*/
        //print(5);
        int fib=fibonacci(6);
        System.out.println(fib);
    }

    private static int fibonacci(int i) {
        if(i < 2){
            return i;
        }

        return fibonacci(i-2)+fibonacci(i-1);
    }

    private static void print(int n) {
        if(n==0){
            return;
        }
        System.out.println(n);
        print(n-1);

    }

    private static boolean palindrome(String str) {

       /* int start = 0, end = str.length()-1, count = 0;
        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                count =1;
                start++;
                end--;

            }
            else{
                break;
            }
        }
        if(count == 1){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }*/
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}

