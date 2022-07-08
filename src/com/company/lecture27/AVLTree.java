package com.company.lecture27;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AVLTree<T extends Comparable<T>> {
    Node root;

    class Node {
        T value;
        Node left;
        Node right;
        int height;


        Node(T value){
            this.value = value;
            this.height = 1;
        }
    }

    public void insert(T value){
        this.root = insert(root, value);
    }
    private Node insert(Node node, T value){
        if(node == null){
            node  = new Node(value);
            return  node;
        }
        if(node.value.compareTo(value) < 0){
            node.right = insert(node.right, value);
        }
        if(node.value.compareTo(value) > 0){
            node.left = insert(node.left, value);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        node = balancing(node);
        return node;
    }

    private Node balancing(Node node) {
        //R rotation
        if(height(node.right) - height(node.left) > 1){
            // we have written this height function in if loop (height())like this
            // id to avoid null pointer exception if any node has its children has null;
            //if right is bigger than left than just use LL rotation

            /* //Right Left Rotation(RL rotation) */
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
            }
            node = leftRotate(node);
        }

        if(height(node.left) - height(node.right) > 1){
            //Left Right Rotation(LR rotation)
            if(height(node.left.right) - height(node.left.left) >0){
                node.left = leftRotate(node.left);
            }
            node = rightRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node x) {
         Node Y = x.left;
         Node Transfer = Y.right;

         Y.right = x;
         x.left = Transfer;


        //Updating height after updation
        Y.height = Math.max(height(Y.left), height(Y.right))+1;
        x.height = Math.max(height(x.left), height(x.right))+1;
         /*
                    X
                   / \
                   y  Null
                  / \
               Null  T
          */
         return Y;
    }

    private Node leftRotate(Node x) {
        Node Y = x.right;
        Node Transfer = Y.left;

        Y.left = x;
        x.right = Transfer;

        //Updating height after updation
        Y.height = Math.max(height(Y.left), height(Y.right))+1;
        x.height = Math.max(height(x.left), height(x.right))+1;
         /*
                     X
                   /  \
                 Null   y
                      / \
                     T  Null
          */
        return Y;
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        display(node.right, indent+'\t');
        System.out.println(indent + node.value);
        display(node.left, indent+'\t');
    }

    public void range(T start, T end){
        range(start, end, root);
    }
    private void range(T start, T end, Node node){
        if(node == null){
            return ;
        }
        if(node.value.compareTo(start) > 0){
            range(start, end, node.left);
        }
        if(node.value.compareTo(start) >= 0 && node.value.compareTo(end) <=0){
            System.out.print(node.value+" ");
        }
        if(node.value.compareTo(end) < 0){
            range(start, end, node.right);
        }
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
    }
    public void rightShift(){
        rightShift(root);
    }
    private void rightShift(Node node){
        if(node == null){
            return;
        }
        if(node.left != null){
            Node temp = node.right;
            node.right = node.left;
            node.left = null;
            Node tr = node.right;
            while(tr.right != null){
                tr = tr.right;
            }
            tr.right = temp;
        }
        rightShift(node.right);
    }

}

