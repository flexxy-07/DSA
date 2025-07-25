package BST;
import java.util.*;

public class ConstructBST extends BST{
    private int preIndex = 0;
    public TreeNode BstFromPreorder(int[] preOrder) {
        int[] inOrder = (Arrays.copyOf(preOrder,preOrder.length));
        Arrays.sort(inOrder);
        return buildTree(inOrder,preOrder,0,inOrder.length - 1);
    }
    private TreeNode buildTree(int[] inOrder, int[] preOrder, int start, int end) {
        if (start > end){
            return null;
        }
        int val = preOrder[preIndex++];
        TreeNode root = new TreeNode(val);

        int index = getIndex(val,inOrder,start,end);

        root.left = buildTree(inOrder,preOrder,start,index - 1);
        root.right = buildTree(inOrder,preOrder,index + 1,end);

        return root;
    }
    private int getIndex(int val, int[] inOrder, int start, int end) {
        for (int i = start; i <= end ; i++) {
                if (val == inOrder[i])
                    return i;
        }
        return -1;
    }

    // More Optimized
    public TreeNode bstFromPreorder(int[] preOrder){
        return Recurse(preOrder,0,preOrder.length - 1);
    }
    private TreeNode Recurse(int[] preOrder, int start, int end){
        if (start > end) return null;

        TreeNode root = new TreeNode(preOrder[start]);
        int i;
        for ( i = start + 1; i <= end ; i++) {
                if (preOrder[i] > root.val)
                    break;
        }
        root.left = Recurse(preOrder, start + 1,i - 1);
        root.right = Recurse(preOrder,i,end);

        return root;
    }


}
