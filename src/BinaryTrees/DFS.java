package BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFS extends BinaryTree{
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    //    int h = height(root);
        return diameter - 1;
    }

//    private int height(TreeNode node) {
//        if (node == null){
//            return 0;
//        }
//        int h1 = height(node.left);
//        int h2 = height(node.right);
//
//        int dia = h1 + h2 + 1;
//        diameter = Math.max(dia,diameter);
//
//        return Math.max(h1,h2) + 1;
//    }

    public TreeNode invertTree(TreeNode root) {
        swapNodes(root);
        return root;

    }
    private void swapNodes(TreeNode node){
        if (node == null){
            return;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        swapNodes(node.left);
        swapNodes(node.right);
    }
    public TreeNode InvertTree(TreeNode root){
        if (root == null){
            return null;
        }

        TreeNode left = InvertTree(root.left);
        TreeNode right = InvertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int h1 = maxDepth(root.left);
        int h2 = maxDepth(root.right);

        return Math.max(h1,h2) + 1;
    }

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode current = root;
        while (current != null){
            if (current.left != null){
                TreeNode temp = current.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }
    private boolean isValid(TreeNode node,Integer low, Integer high){
        if (node == null){
            return true;
        }
        if (low != null && node.val <= low){
            return false;
        }
        if (high != null && node.val >= high){
            return false;
        }
        boolean left = isValid(node.left,low,node.val);
        boolean right = isValid(node.right,node.val,high);

        return left && right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        inOrder(root,list);
//        return list.get(k - 1);
//    }
//    private void inOrder(TreeNode node,List<Integer> list){
//        if (root == null){
//            return;
//        }
//        inOrder(node.left,list);
//        list.add(node.val);
//        inOrder(node.right,list);
//    }
    public int kthSmallest(TreeNode root, int k){
        int counter = 0;
        return helper(root,k,counter).val;
    }
    private TreeNode helper(TreeNode node,int k, int counter){
        if (node == null){
            return null;
        }
        TreeNode left = helper(node.left,k,counter);
        if (left != null){
            return left;
        }
        counter++;
        if (counter == k){
            return node;
        }
        return helper(node.right,k,counter);
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return (
                flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right)) ||
                (flipEquiv(root1.left,root2.right)&&(flipEquiv(root1.right, root2.left))
                );
    }
// Url : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
    int maxSum = Integer.MIN_VALUE;
    public int maxLevelSum(TreeNode root) {
        if (root == null){
            return 1;
        }
        Deque<TreeNode> list = new ArrayDeque<>();
        list.push(root);
        int level = 0;
        int lvlCounter = 1;
        while (!list.isEmpty()){
            int lvl = list.size();
            int currSum = 0;
            for (int i = 0; i < lvl; i++) {
                TreeNode node = list.poll();
                currSum += node.val;
                if (node.left != null){
                    list.addLast(node.left);
                }
                if (node.right != null){
                    list.addLast(node.right);
                }
            }
            if (currSum > maxSum){
                maxSum = currSum;
                level = lvlCounter;
            }
            lvlCounter++;
        }
            return level;
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null){
            return false;
        }
        Deque<TreeNode> list = new ArrayDeque<>();
        list.addLast(root);
        int lvlCounter = 0;
        while (!list.isEmpty()){
            int lvl = list.size();
            int val = root.val;
            if(lvlCounter % 2 == 0){
                for (int i = 0; i < lvl; i++) {
                    TreeNode curr = list.poll();
                    int currVal = curr.val;
                    if (currVal % 2 == 0){
                        return false;
                    }
                    if (currVal < val){
                        return false;
                    }
                    if (curr.left != null){
                        list.addLast(curr.left);
                    }
                    if (curr.right != null){
                        list.addLast(curr.right);
                    }
                    val = currVal;
                }
            }
            if (lvlCounter % 2 != 0){
                for (int i = 0; i < lvl; i++) {
                    TreeNode curr = list.poll();
                    int currVal = curr.val;
                    if (currVal % 2 != 0){
                        return false;
                    }
                    if (currVal > val){
                        return false;
                    }
                    if (curr.left != null){
                        list.addLast(curr.left);
                    }
                    if (curr.right != null){
                        list.addLast(curr.right);
                    }
                    val = currVal;
                }
            }
            lvlCounter++;
        }
        return true;
    }

    // Url : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

    int stepCount = 0;
    boolean left = false;
    public int longestZigZag(TreeNode root) {
        deepDiver(root);
        return stepCount;
    }
    private void deepDiver(TreeNode root){
        if (root == null){
            return;
        }
        if(!left){
            left = !left;
            deepDiver(root.left);
            stepCount++;
        }
        deepDiver(root.right);
        stepCount++;
    }

    // Url : https://leetcode.com/problems/trim-a-binary-search-tree/submissions/1704995204/
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if (root.val < low ){
            return trimBST(root.right,low,high);
        }
        if (root.val > high){
            return trimBST(root.left,low,high);

        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);

        return root;
    }
}
