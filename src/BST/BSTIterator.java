package BST;
import java.util.*;

public class BSTIterator extends BST{
// Url : https://leetcode.com/problems/binary-search-tree-iterator/

    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        addleftpath(root);
    }
    private void addleftpath(TreeNode root){
        while (root != null ){
            stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null){
            addleftpath(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
