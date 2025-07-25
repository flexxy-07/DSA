package BinaryTrees.AncestorProblems;

import BinaryTrees.BinaryTree;
import com.sun.source.tree.Tree;

public class Ancestors extends BinaryTree {

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

    // Url : https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

    // the below approach is wrong since it doesn't maintain the ancestor relation across paths.
//    public int maxAncestorDiff(TreeNode root) {
//        return maxDiff(root);
//    }
//    private int maxDiff(TreeNode root){
//       if (root == null){
//           return 0;
//       }
//       int maxLeft = maxVal(root.left,root.val);
//       int minLeft = minVal(root.left,root.val);
//
//       int maxRight = maxVal(root.right,root.val);
//       int minRight = minVal(root.right,root.val);
//
//       int ans1 = maxLeft - minLeft;
//       int ans2 = maxRight - minRight;
//                                                                  ///////  WRONG ❌❌❌❌❌❌
//       return Math.max(ans1,ans2);
//    }
//    private int maxVal(TreeNode root, int max){
//        if (root == null){
//            return max;
//        }
//        if (root.val > max){
//            max = root.val;
//        }
//        int maxLeft = maxVal(root.left,max);
//        int maxRight = maxVal(root.right,max);
//
//        return Math.max(maxLeft,maxRight);
//    }
//    private int minVal(TreeNode root, int min){
//        if (root == null){
//            return min;
//        }
//        if (root.val < min){
//            min = root.val;
//        }
//        int minLeft = minVal(root.left,min);
//        int minRight = minVal(root.right,min);
//
//        return Math.min(minLeft,minRight);
//    }

//   CORRECT APPROACH  ✅✅✅✅✅✅
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
    private int helper(TreeNode root, int min , int max){
        if (root == null){
            return max - min;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int left = helper(root.left,min,max);
        int right = helper(root.right,min,max);

        return Math.max(left,right);
    }

// Url : https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
//  Approach : Find the max depth, dive into its previous level, return the root which has two children;

    private int maxDepth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        return deepDive(root,0);
    }
    private TreeNode deepDive(TreeNode root, int currDepth){
        if (root == null){
            return null;
        }
        if (currDepth == maxDepth){
            return root;
        }
        TreeNode left = deepDive(root.left,currDepth + 1);
        TreeNode right = deepDive(root.right,currDepth + 1);

        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    private void depth(TreeNode root, int depth){
        if (root == null){
            return ;
        }
         maxDepth = Math.max(maxDepth,depth);
         depth(root.left,depth + 1);
         depth(root.right, depth + 1);
    }
}
