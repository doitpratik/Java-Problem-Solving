package com.company.lecture26;

public class BinarySearchTree<T extends Comparable<T>> {
    Node root;
    class Node {
       T value;
       Node left;
       Node right;

       Node(T value){
           this.value = value;
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
        return node;
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

    public boolean find(T value){
        return find(root, value);
    }
    private boolean find(Node node, T value){
        if(node == null){
            return false;
        }
        if(node.value.equals(value)){
            return true;
        }
        return (node.value.compareTo(value) > 0 ? (find(node.left, value)) : (find(node.right, value)));
    }
    public T max(){
        return max(root);
    }
    private T max(Node node){
        if(node == null){
            return null;
        }
        T maxval = node.value;
        T leftmax = max(node.left);
        T rightmax = max(node.right);
        if(leftmax != null && maxval.compareTo(leftmax) < 0){
            maxval = leftmax;
        }
        if(rightmax != null && maxval.compareTo(rightmax) < 0){
            maxval = rightmax;
        }
        return maxval;
    }

}
