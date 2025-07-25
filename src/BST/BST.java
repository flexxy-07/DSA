package BST;

public class BST {
    private TreeNode root;

    public BST (){

    }
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        private int height;

        public TreeNode(int val){
            this.val = val;
        }
        public int getVal() {
            return val;
        }
    }
    public int height(TreeNode node){
        if (node == null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void display(){
        display(root,"Root Node: ");
    }

    private void display(TreeNode node, String details) {
        if (node == null){
            return;
        }
        System.out.println(details + node.getVal());

        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }
    public void insert(int val){
        root = insert(val,root);
    }
    private TreeNode insert(int val, TreeNode node ) {
        if (node == null){
            node = new TreeNode(val);
            return node;
        }
        if (val > node.val){
            node.right = insert(val,node.right);
        }
        else if (val < node.val) {
            node.left = insert(val,node.left);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(TreeNode node){
        if (root == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populateSorted(int[] arr){
        populateSorted(arr,0,arr.length);
    }

    private void populateSorted(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (start + end) / 2;
        this.insert(arr[mid]);
        populateSorted(arr,start,mid);
        populateSorted(arr,mid+1,end);
    }
}
