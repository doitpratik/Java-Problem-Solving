package com.company.lecture2;

import javax.sound.midi.Soundbank;
import java.io.InputStream;
import java.util.Scanner;

public class Leapyear {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int a = sc.nextInt();
        if(a%4==0){
            if(a%100==0){
                if(a%400==0){
                    System.out.println("Leap Year");
                }
                else{
                    System.out.println("Not a Leap Year");
                }
            }
            else{
                System.out.println("Leap Year");
            }
        }
        else{
            System.out.println("Not a  Leap Year");
        }
    }
}
