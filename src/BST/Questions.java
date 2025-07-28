package BST;

import BinaryTrees.BinaryTree;
import LinkedList.LeetCode.LinkedList;

public class Questions extends BinaryTree {
 // Url : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
//    public TreeNode sortedListToBST(ListNode head) {
//
// }
//


// Url :  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/1710803030/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val,q.val);
        int min = Math.min(p.val,q.val);
        return Recurse(root,max,min);
    }
    private TreeNode Recurse(TreeNode root, int max, int min){
        if (root == null){
            return null;
        }
        if (root.val > min && root.val < max){
            return root;
        }
        if (root.val > max){
            return Recurse(root.left,max,min);
        }
        else if (root.val < min) {
            return Recurse(root.right,max,min);
        }
        return root;
    }

// Url : https://leetcode.com/problems/recover-binary-search-tree/
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
       iot(root);
       swap(first,second);
    }
    private void iot(TreeNode root){
        if (root == null){
            return;
        }
        iot(root.left);
        if (prev != null && root.val < prev.val){
            if (first == null){
                first = prev;
            }else{
                second = prev;
            }
        }
        prev = root;
        iot(root.right);
    }
    private void swap(TreeNode first, TreeNode second){
        int temp  = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
