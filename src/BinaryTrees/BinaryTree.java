package BinaryTrees;

import java.util.Scanner;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree(){
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    // insert the elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new TreeNode(value);
        populate(scanner,root);
    }

    private  void populate(Scanner scanner, TreeNode node) {
        System.out.println("Do you want to enter left of " +  node.val);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left of " + node.val);
            int val = scanner.nextInt();
            node.left = new TreeNode(val);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to enter right of " +  node.val);
        boolean right = scanner.nextBoolean();

        if (right){
            System.out.println("Enter the value of the right of " + node.val);
            int val = scanner.nextInt();
            node.right = new TreeNode(val);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(this.root,"");
    }

    private void display(TreeNode node, String indent) {
        if (node == null){
            return;
        }
        System.out.println(node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(TreeNode node) {
        if (node == null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

}
