package BinaryTrees;

import java.util.*;
public class Questions extends BinaryTree{
//   the below given is my approach..i just reverse the list before adding it to the ans list;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int lvlCount = 0;
        while (!que.isEmpty()){

            int lvl = que.size();
            List<Integer> inner = new ArrayList<>(lvl);
            for (int i = 0; i < lvl; i++) {
                    TreeNode curr = que.poll();
                    inner.add(curr.val);
                    if (curr.left != null) {
                        que.add(curr.left);
                    }
                    if (curr.right != null){
                        que.add(curr.right);
                    }
                }
                    if (lvlCount % 2 != 0){
                        Collections.reverse(inner);
                    }
                    list.add(inner);
                    lvlCount++;
                }
                return list;
    }


    //Guess...Optimised Approach ||  gOT NO DIFFERENCE IN BELOW AND ABOVE
    public List<List<Integer>> ZigZagLevelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int lvlCount = 0;

        while (!que.isEmpty()){
            int lvl = que.size();
            List<Integer> inner = new ArrayList<>(lvl);
            if(lvlCount % 2 == 0){
                // normal
                for (int i = 0; i < lvl; i++) {
                    TreeNode curr = que.pollFirst();
                    inner.add(curr.val);
                    if (curr.left != null){
                        que.addLast(curr.left);
                    }
                    if (curr.right != null){
                        que.addLast(curr.right);
                    }

                }
            }else{
                // reverse
                for (int i = 0; i < lvl; i++) {
                    TreeNode curr = que.pollLast();
                    inner.add(curr.val);
                    if (curr.right != null){
                        que.addFirst(curr.right);
                    }
                    if (curr.left != null){
                        que.addFirst(curr.left);
                    }
                }
            }
            list.add(inner);
            lvlCount++;
        }
        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()){
            int lvl = que.size();
            for (int i = 0; i < lvl; i++) {
                TreeNode node = que.poll();
                if (i == lvl - 1){
                    list.add(node.val);
                }
                if (node.left != null){
                    que.add(node.left);
                }
                if (node.right != null){
                    que.add(node.right);
                }
            }
        }
        return list;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root,0,xx) == level(root,0,yy)) && !isSibling(root,xx,yy);
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null){
            return false;
        }
        return (
                node.left == x && node.right == y || node.left == y && node.right == x
                || isSibling(node.left,x,y) || isSibling(node.right,x,y)
        );
    }

    private int level(TreeNode node, int lvl, TreeNode x) {
        if (node == null){
            return 0;
        }
        if (node == x){
            return lvl;
        }
        int l = level(node.left,lvl+1,x);
        if (l != 0){
            return l;
        }
        return level(node.right,lvl+1,x);
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null){
            return null;
        }
        if(node.val == x){
            return node;
        }
        TreeNode ans = findNode(node.left,x);
        if (ans != null){
            return ans;
        }
        return findNode(node.right,x);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left,right.right) && isMirror(left.right, right.left);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (null == root){
            return null;
        }
        Recurse(root.left, root.right, 1);
        return root;
    }

    private void Recurse(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null){
            return ;
        }
        if (level % 2 != 0){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        Recurse(node1.left,node2.right,level + 1);
        Recurse(node1.right, node2.left, level + 1);
    }
    private int sum = 0;
  //  private int level = 0;
    public int deepestLeavesSum(TreeNode root) {
        traversal(root,0);
        helper(root,0);
        return sum;
    }
    void traversal(TreeNode root, int lvl){
        if (root == null){
            return;
        }
        level = Math.max(level,lvl);
        traversal(root.left,lvl + 1);
        traversal(root.right, lvl + 1);
    }
    private void helper(TreeNode node,int lvl){
        if (node == null){
            return;
        }
        helper(node.left,lvl+1);
        if (node.left == null && node.right == null) {
            if (lvl == level) {
                sum += node.val;
            }
        }
        helper(node.right,lvl + 1);
    }


    // Url : https://leetcode.com/problems/maximum-binary-tree/description/
    public TreeNode constructMaximumBinaryTree(int[] arr) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : arr){
            TreeNode current = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num){
                current.left = stack.pop();
            }
            if (!stack.isEmpty()){
                stack.peek().right = current;
            }
            stack.push(current);
        }
        while (stack.size() > 1){
            stack.pop();
        }
        return stack.peek();
    }


    // Url : https://leetcode.com/problems/balance-a-binary-search-tree/description/
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        root = buildTree(list,0,list.size() - 1);
        return root;
    }

    private TreeNode buildTree(List<Integer> list,int start, int end){
        if (start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list,start,mid - 1);
        root.right = buildTree(list,mid + 1,end);

        return root;
    }
    private void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        inorder(root1,first);
        inorder(root2,second);

        return merge(first,second);
    }
    private List<Integer> merge(List<Integer> first, List<Integer> second){
        int i = 0;
        int k = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < first.size() && k < second.size()){
            if (first.get(i) > second.get(k)){
                ans.add(second.get(k++));
            }else{
                ans.add(first.get(i++));
            }
        }
        while (i < first.size()){
            ans.add(first.get(i++));
        }
        while (k < second.size()){
            ans.add(second.get(k++));
        }
        return ans;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null && root.val == target){
            return null;
        }
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);

        if (root.left == null && root.right == null && root.val == target){
            return null;
        }

        return root;
    }

    // Url : https://leetcode.com/problems/count-good-nodes-in-binary-tree/
    int counter = 0;
    public int goodNodes(TreeNode root) {
        countNodes(root,root.val);
        return counter;
    }
    private void countNodes(TreeNode root, int checkValue){
        if (root == null){
            return;
        }
        if (root.val >= checkValue){
            counter++;
            checkValue = root.val;
        }
        countNodes(root.left, root.val);
        countNodes(root.right, root.val);
    }

   // Url : https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        else{
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
//  Url : https://leetcode.com/problems/find-bottom-left-tree-value/

    // My solution...Pretty Good!
    private int level = 0;
    public int findBottomLeftValue(TreeNode root) {

        getMaxLevel(root,0);
        return leftWing(root,0);
    }
    private Integer leftWing(TreeNode root, int lvl){
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null && lvl == level){
            return root.val;
        }
        Integer ans = leftWing(root.left,lvl + 1);
        if (ans == null){
            return leftWing(root.right, lvl +1 );
        }
        return ans;
    }
    private void getMaxLevel(TreeNode root, int lvl){
        if (root == null){
            return;
        }
        level = Math.max(level,lvl);
        getMaxLevel(root.left,lvl + 1);
        getMaxLevel(root.right, lvl + 1);
    }
    // Optimized
    private int maxDepth = 0;
    private int leftMost = -1;
    public int findBottomLeftVal(TreeNode root){
        LeftWing(root,0);
        return leftMost;
    }
    private void LeftWing(TreeNode root, int lvl){
        if (root == null){
            return;
        }
        if (maxDepth > lvl){
            leftMost = root.val;
            maxDepth = lvl;
        }
        LeftWing(root.left, lvl + 1);
        LeftWing(root.right, lvl + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addValuesBFS(root,list);
        return list;
    }
    private void addValuesBFS(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()){
            int level = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.val > max){
                    max = node.val;
                }
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
            list.add(max);
        }
    }
    int val = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root,null);
        return val;
    }
    private void helper(TreeNode current, TreeNode prev){
        if (current == null || current.left == null || current.right == null){
            return;
        }
        if(prev != null && prev.val % 2 == 0){
            if (current.left != null) val += current.left.val;
            if (current.right != null) val += current.right.val;
        }
        helper(current.left,current);
        helper(current.right,current);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root .left == null && root. right == null && root.val != 1){
            return null;
        }
        pruneTree(root.left);
        pruneTree(root.right);

        if (root .left == null && root. right == null && root.val != 1){
            return null;
        }
        return root;
    }
}


