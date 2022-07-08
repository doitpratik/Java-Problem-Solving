package com.company.lecture22;

import java.util.LinkedList;

public class Reverse {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(actual);
    }


}
