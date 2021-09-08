package com.company.lecture25;

import java.util.*;

public class ProbSol {
    public static void main(String[] args) {
       /* String str1= "Hello World!!";
        System.out.println(freq(str1));
        String[] Str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(Str));*/
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(str));
    }

    private static HashMap<Character, Integer> freq(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        return map;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;

            }
            String keyStr = String.valueOf(ca);
            System.out.println(keyStr);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hp=new HashMap<>();
        // hashmap to contains all substring of 10 length and frequency map
        for(int i=0;i+10<=s.length();i++){
            String temp=s.substring(i,i+10);
            hp.put(temp,hp.getOrDefault(temp,0)+1);
        }

        List<String> ans=new ArrayList<>();
        for(String ss:hp.keySet()){
            if(hp.get(ss)>1) ans.add(ss);
        }
        // traverse in map and string with greater freq can be stored
        return ans;
    }
}
