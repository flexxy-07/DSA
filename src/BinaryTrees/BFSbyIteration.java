package BinaryTrees;
import java.util.*;
public class BFSbyIteration extends BinaryTree{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()){
            int lvl = que.size();
            List<Integer> inner = new ArrayList<>(lvl);
            for (int i = 0; i < lvl; i++) {
                TreeNode curr = que.poll();
                inner.add(curr.val);
                if (curr.left != null){
                    que.add(curr.left);
                }
                if (curr.right != null){
                    que.add(curr.right);
                }
            }
            ans.add(inner);
        }
            return ans;
    }
}
