package com.company.lecture27;

import javax.swing.*;

public class BSTClient {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(23);
        bst.insert(26);
        bst.insert(37);
        bst.insert(12);
        bst.insert(87);
        bst.insert(16);
        bst.insert(64);

        bst.range(20,70);
        //System.out.println(bst.sortedList());

       /* Integer[] sorted = {6, 10, 12, 14, 19, 21, 27, 36, 42, 47};
        bst.populateFromSortedArray(sorted);*/
        for (int i = 1; i <= 10 ; i++) {
            bst.insert(i);
        }
        //bst.display();

        AVLTree<Integer> avlTree = new AVLTree<>();
        for(int i= 1; i <= 10; i++){
            avlTree.insert(i);
        }
        //avlTree.display();
    }
}
