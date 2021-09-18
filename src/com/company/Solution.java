package com.company;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> Intersection = new ArrayList<>();
        for(int i: nums1){
            map.put(i, map.get(i)+1);
        }
        for (int j: nums2) {
            if(map.containsKey(j)){
                Intersection.add(j);
                map.put(j, map.get(j)-1);
            }
        }
        int[] index =new int[Intersection.size()] ;
        int i =0;
        for(Integer x : Intersection){
            index[i++] = x;
        }
        Intersection = null;
        map = null;
        return index;
    }
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = 0, sum2= 0;
        for(int x : aliceSizes){
            sum1 += x;
        }
        for(int y : bobSizes){
            sum2 += y;
        }
        int sum = (sum1-sum2)/2;
        Set<Integer> set = new HashSet<>();
        for(int i : aliceSizes){
            set.add(i);
        }
        for(int i = 0; i < bobSizes.length; i++){
            if(set.contains(sum+bobSizes[i])){
                return new int[] {sum+bobSizes[i], bobSizes[i]};
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1};
        int[] b = new int[]{2, 2};

    }
}