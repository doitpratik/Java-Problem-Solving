package com.company.lecture2;

import java.util.Scanner;

public class SimpleInterest {
    public static double interest(double p, double r, double t) {
        double si = (p * r * t)/100.0;
        return si;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double principle = sc.nextDouble(), rate_of_interest =sc.nextDouble(), no_of_year= sc.nextDouble();
        System.out.println(interest(principle, rate_of_interest, no_of_year));

        Main.happy();
    }
}
