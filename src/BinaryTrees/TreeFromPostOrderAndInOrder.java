package BinaryTrees;

public class TreeFromPostOrderAndInOrder extends BinaryTree{
// Url : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

    int postIndex;
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        postIndex = postOrder.length - 1;
        return constructTree(inOrder,postOrder,0,inOrder.length - 1);
    }
    private TreeNode constructTree(int[] inOrder, int[] postOrder, int start, int end){
        if(start > end) return null;

        int val = postOrder[postIndex--];
        TreeNode root = new TreeNode(val);

        int index = getIndex(val,inOrder,start,end);

        root.right = constructTree(inOrder,postOrder,index + 1,end);
        root.left = constructTree(inOrder,postOrder, start, index -1);

        return root;
    }
    private int getIndex(int val,int[] inOrder, int start, int end){
        for(int i = start; i <= end; i++){
            if(val == inOrder[i]){
                return i;
            }
        }
        return -1;
    }
}
