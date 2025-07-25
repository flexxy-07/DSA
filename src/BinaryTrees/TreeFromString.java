package BinaryTrees;

public class TreeFromString extends BinaryTree{
 // Url : https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

     int i= 0;
     public TreeNode recoverFromPreorder(String traversal) {
        i = 0;
        return build(traversal, 0);
    }

     public TreeNode build(String traversal, int depth){
        if (i >= traversal.length()){
            return null;
        }
        int D = 0;
        while (traversal.charAt(i) == '-'){
            D++;
            i++;
        }

        if (D != depth){
            i = i - D;
            return null;
        }

        int val = 0;
        while (Character.isDigit(traversal.charAt(i))){
            val = val * 10 + traversal.charAt(i) - '0';
            i++;
        }
        TreeNode node = new TreeNode(val);

        node.left = build(traversal,depth + 1);
        node.right = build(traversal,depth + 1);

        return node;
     }


}
