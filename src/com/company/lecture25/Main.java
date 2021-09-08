package com.company.lecture25;

public class Main {
   public static void main(String[] args) {
      CustomMap<String, String> map = new CustomMap<>();
      map.put("Apple", "Red Fruit");
      map.put("Mango", "Yellow Fruit");
      System.out.println(map);
      map.put("Mango", "Sweet Fruit");
      System.out.println(map);
      System.out.println(map.keySet());
      System.out.println(map.values());
   }

}
