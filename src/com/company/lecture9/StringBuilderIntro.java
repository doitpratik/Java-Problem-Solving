package com.company.lecture9;

public class StringBuilderIntro {
    public static void main(String[] args) {
        String string = "soham";
        StringBuilder stringbuilder = new StringBuilder("soham");
        for (int i = 0; i < 100000000; i++) {
            stringbuilder.append("a");
        }
        System.out.println(stringbuilder);
    }
}
