package BinaryTrees;

import java.util.HashMap;

public class TreeFromPreOrderAndInorder extends BinaryTree{
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return constructTree(preorder,inorder,0,inorder.length - 1,map);
    }
    private TreeNode constructTree(int[] preOrder, int[] inOrder, int start, int end,HashMap<Integer,Integer> map){
        if (start > end){
            return null;
        }
        int val = preOrder[preIndex++];
        TreeNode root = new TreeNode(val);

        if(start == end){
            return root;
        }
        int index = map.get(val);

        root.left = constructTree(preOrder,inOrder,start,index -1,map );
        root.right = constructTree(preOrder,inOrder,index + 1,end,map);

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
