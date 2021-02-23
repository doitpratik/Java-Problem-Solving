package com.company.lecture5;

public class DecimaltoBinary {
    public static void main(String[] args) {
        int num =20;
        System.out.println(dectobin(num));
    }

    public static int dectobin(int num) {
        int res=0,place=1;
        while(num>0){
            int rem = num % 2;
            num /= 2;
            res = res + rem*place;
            place *= 10;
        }
        return res;
    }

}
