package com.company.lecture26;

public class BSTClient {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
       /* bst.insert(26);
        bst.insert(32);
        bst.insert(12);
        bst.insert(16);
        bst.insert(10);
        bst.insert(36);
        bst.insert(28);
        bst.insert(34);
        bst.insert(15);
        bst.insert(27);
        bst.insert(26);*/
        bst.insert(23);
        bst.insert(37);
        bst.insert(12);
        bst.insert(16);
        bst.insert(26);
        bst.insert(87);
        bst.insert(64);
        bst.display();
        System.out.println(bst.find(10));
        System.out.println(bst.max());
        System.out.println(bst.min());
        bst.inorder();
        bst.preorder();
        bst.postorder();
    }
}
