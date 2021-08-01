package com.company.lecture9;

public class StringBuilderIntro {
    public static void main(String[] args) {
        String string = "soham";
        StringBuilder stringbuilder = new StringBuilder("soham");
        for (int i = 0; i < 100000000; i++) {
            stringbuilder.append("a");
        }
        System.out.println(stringbuilder);

        // In comparison to String Builder, String buffer is thread safe and it works
        // synchronously and in it inefficient in case of time
        StringBuffer stringbuffer = new StringBuffer("Soham");
        for (int i = 0; i < 100000000; i++) {
            stringbuffer.append("a");
            //string = string + 'a';
        }
        System.out.println(stringbuffer);
        System.out.println(stringbuffer.indexOf("h"));
        System.out.println(stringbuilder.reverse());
    }
}
