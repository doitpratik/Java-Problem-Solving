package com.company.lecture13;

import java.util.Arrays;

public class Frequencymatrix {
    public static void main(String[] args) {
        String str ="aacsdebbccccaaaaaaaaaaaaaaa";
        int[] freq = freqMatrix(str);
        System.out.println(Arrays.toString(freq));
    }

    private static int[] freqMatrix(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int j= str.charAt(i) - 'a';
            freq[j]++;
        }
        return freq;
    }
}
