package com.company;

public class Main {
    public static void main(String[] args) {
        LLpractice ll = new LLpractice();
        ll.insertFirst(5);
        ll.insertFirst(4);
        ll.insertFirst(3);
        ll.insertFirst(2);
        ll.insertLast(6);
        ll.insertSpecific(1,5);
        System.out.println(ll);
    }
}
