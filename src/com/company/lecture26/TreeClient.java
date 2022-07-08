package com.company.lecture26;

public class TreeClient {
    public static void main(String[] args) {
        BinaryTree<Integer> BT = new BinaryTree<>();

        BT.insert(1);
        BT.insert(2, 'L');
        BT.insert(5,'R');
        BT.insert(3, 'L', 'L');
        BT.insert(4, 'L', 'R');
        BT.insert(6, 'R', 'R');
        BT.insert(7, 'R', 'R', 'L');

        BT.display();
        System.out.println(BT.find(2));
        System.out.println(BT.max());

        BT.rightShift();
        BT.display();
    }
}
