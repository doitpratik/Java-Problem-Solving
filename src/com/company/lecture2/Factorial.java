package com.company.lecture2;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int a = sc.nextInt(),fact=1;
            if (a == 0 || a == 1){
                System.out.println(1);
                continue;
            }
            for (int i=2;i<=a;i++){
                fact *= i;
            }
            System.out.println(fact);
        }
    }
}
