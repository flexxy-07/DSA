package BinaryTrees;

import java.util.*;

public class DFSbyStack extends BinaryTree{
    List<Integer> vals = new ArrayList<>();
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.poll();
            vals.add(node.val);
            if (node.right != null){
                vals.add(node.right.val);
            }
            if (node.left != null){
                vals.add(node.left.val);
            }
        }
    }
}
