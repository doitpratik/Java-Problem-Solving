package com.company.lecture22;

import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        CustomLinkedList LL = new CustomLinkedList();
        LL.insertLast(1);
        LL.insertLast(4);
        LL.insertLast(2);
        LL.insertLast(5);
        LL.insertSpecific(3, 2);
        LL.insertFirst(0);
        //System.out.println(LL.deletion());
        //System.out.println(LL.deleteLast());
        System.out.println(LL);
        System.out.println(LL.midEle());
        LL.reverse();
        System.out.println(LL);
        LinkedList<Integer> aa = new LinkedList<>();

    }
}
