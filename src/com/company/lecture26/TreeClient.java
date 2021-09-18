package com.company.lecture26;

public class TreeClient {
    public static void main(String[] args) {
        BinaryTree<Integer> BT = new BinaryTree<>();

        BT.insert(2);
        BT.insert(5, 'L');
        BT.insert(8,'R');
        BT.insert(9, 'L', 'L');
        BT.insert(6, 'L', 'R');
        BT.insert(3, 'R', 'R');
        BT.insert(4, 'R', 'L', 'R');
        BT.insert(11, 'R', 'L', 'R');
        BT.insert(-2, 'R', 'R');
        BT.insert(0);
        BT.display();
        System.out.println(BT.find(2));
        System.out.println(BT.max());
    }
}
