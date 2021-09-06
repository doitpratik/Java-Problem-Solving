package com.company.lecture24;

import java.util.HashMap;
import java.util.Map;

public class Ruun {
    public static void main(String[] args) {
        CustomSet<String> set = new CustomSet<>();
        set.add("Pratik");
        set.add("Sudhanshu");
        set.add("Soham");
        set.add("Sagar");
        set.add("Pratik");
        System.out.println(set);
        set.remove("Soham");
        System.out.println(set);
        System.out.println(set.contains("Soham"));
        Map<Character, Integer> map = new HashMap<>();

    }
}
