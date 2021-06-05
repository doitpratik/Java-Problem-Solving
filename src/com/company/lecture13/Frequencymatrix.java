package com.company.lecture13;

import java.util.Arrays;

public class Frequencymatrix {
    public static void main(String[] args) {
        String str ="aabbcc";
        int[] freq = freqMatrix(str);
        System.out.println(Arrays.toString(freq));
        String s ="aab";
        Substring_Lexopermu("",freqMatrix(s),s.length());
    }

    private static void Substring_Lexopermu(String processed, int[] freqMat, int length) {
        if(length == 0){
            System.out.println(processed);
            return;
        }
        for (int i = 0; i < freqMat.length; i++) {
            if(freqMat[i] > 0){
                freqMat[i]--;
                Substring_Lexopermu(processed+(char)(i+'a'), freqMat, length-1);
                freqMat[i]++;

            }
        }
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
