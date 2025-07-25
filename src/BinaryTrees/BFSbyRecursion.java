package BinaryTrees;
import java.util.*;
public class BFSbyRecursion extends BinaryTree{

    BinaryTree tree = new BinaryTree();

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        BFS(list,0,root);
        return list;
    }
    private void BFS(List<List<Integer>> list, int level, TreeNode node){
        if (node == null){
            return ;
        }
        if (list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);

        BFS(list,level +1 , node.left);
        BFS(list,level + 1, node.right);

    }


}
