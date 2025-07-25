package BinaryTrees;

public class TreeFromPreOrderAndPostOrder extends BinaryTree{
// Url : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
int preIndex = 0;
    public TreeNode constructFromPrePost(int[] preOrder, int[] postOrder) {
        return buildTree(preOrder,postOrder,0,postOrder.length - 1);
    }
    private TreeNode buildTree(int[] preOrder, int[] postOrder, int start, int end){
        if(preIndex >= preOrder.length || start > end){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preIndex++]);

        if(start == end){
            return root;
        }

        int nextLeftVal = preOrder[preIndex];

        int index = getIndex(nextLeftVal, postOrder, start, end);

        root.left = buildTree(preOrder, postOrder, start, index);
        root.right = buildTree(preOrder, postOrder, index + 1, end - 1);

        return root;
    }
    private int getIndex(int val, int[] preOrder, int start, int end){
        for(int i = start; i <= end; i++){
            if(val == preOrder[i])
                return i;
        }
        return -1;
    }

}
