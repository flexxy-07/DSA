package BinaryTrees;

public class TreeFromPreOrderAndInorder extends BinaryTree{
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder,inorder,0,inorder.length - 1);
    }
    private TreeNode constructTree(int[] preOrder, int[] inOrder, int start, int end){
        if (start > end){
            return null;
        }
        int val = preOrder[preIndex++];
        TreeNode root = new TreeNode(val);

        int index = getIndex(val,inOrder,start, end);

        root.left = constructTree(preOrder,inOrder,start,index -1 );
        root.right = constructTree(preOrder,inOrder,index + 1,end);

        return root;
    }
    private int getIndex(int val, int[] inOrder, int start, int end) {
        for (int i = start; i <= end ; i++) {
            if (val == inOrder[i]){
                return i;
            }
        }
        return -1;
    }
}
