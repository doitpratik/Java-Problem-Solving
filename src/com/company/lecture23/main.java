package com.company.lecture23;

public class main {
    public static void main(String[] args) {
        GenericLLProblems<String> list = new GenericLLProblems<>();
        list.insertLast("Ekta");
        list.insertLast("Mayur");
        list.insertLast("Pratik");
        list.insertLast("Rahul");
        list.insertLast("Sarthak");
        System.out.println(list);

        GenericLLProblems<String> list2 = new GenericLLProblems<>();
        list2.insertLast("Aniket");
        list2.insertLast("Meenal");
        list2.insertLast("Zebra");
        System.out.println(list.merge(list2));

    }
}
