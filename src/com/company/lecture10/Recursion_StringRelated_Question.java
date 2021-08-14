package com.company.lecture10;

public class  Recursion_StringRelated_Question {
    public static void main(String[] args) {
        String str = "abc";
        subsequence_LimitofNo("",str);

    }

    private static void subsequence(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);

        subsequence(processed,unprocessed);
        subsequence(processed+ch, unprocessed);
    }
    private static void subsequence_LimitofNo(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0,i);
            String second = processed.substring(i);
            subsequence_LimitofNo(first+ch+second,unprocessed);
        }

    }
}
