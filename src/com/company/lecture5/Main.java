package com.company.lecture5;

public class Main {
    public static void main(String[] args) {
        int num = 10;

        System.out.println(prime(num));
    }

    public static boolean prime(int n) {
        if (n < 2){
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
