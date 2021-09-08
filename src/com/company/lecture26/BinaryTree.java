package com.company.lecture26;

public class BinaryTree<T extends Comparable<T> > {
    Node root;
    class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;

        }
    }
        //'...' after data types is called as variable argument(varargs) it
        // state that the parameter that are passed in terms of size is undefined it has to assume there
        // can be any number of inputs and any count will be treated as individual input
        // for eg char... dir = "RRLL" dir = "R", dir = "R" dir = "L"
        // also one thing vararg must be declared in the last since it must be easy to difference between the
        // different kind of inputs

    public void insert(T value, char... path){
        this.root = insert(root, value, path, 0);
    }
    private Node insert(Node node, T value, char[] dirs, int index){
        if(node == null){
            node  = new Node(value);
            return  node;
        }
        if(dirs.length == index){
            node.value = value;
            return node;
        }
        if(dirs[index] == 'L'){
            node.left = insert(node.left, value, dirs, index+1);
        }else{
            node.right = insert(node.right, value, dirs, index+1);
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
        return (find(node.left, value) || find(node.right, value));
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


