package BST;



public class AVL {

    private Node root;

    public AVL (){
    }
    public class Node {
        private int val;
        private Node left;
        private Node right;
        private int height;

        public Node(int val){
            this.val = val;
        }
        public int getVal() {
            return val;
        }
    }
    public int height(Node node){
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

    private void display(Node node, String details) {
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
    private Node insert(int val, Node node ) {
        if (node == null){
            node = new Node(val);
            return node;
        }
        if (val > node.val){
            node.right = insert(val,node.right);
        }
        else if (val < node.val) {
            node.left = insert(val,node.left);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return Rotate(node);
    }

    private Node Rotate(Node node) {
        if(height(node.left) - height(node.right) > 1){
            // its left heavy
            if (height(node.left.left) - height(node.left.right) > 0){
                // left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0){
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) < -1){
            // its left heavy
            if (height(node.right.left) - height(node.right.right) < 0){
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0){
                // right left case
                node.right = rightRotate(node.left);
                return leftRotate(node);
            }
        }
            return node;
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        //updating the heights after rotating and balancing the tree;
        p.height = Math.max(height(p.left),height(p.right)) + 1;
        c.height = Math.max(height(c.left),height(c.right)) + 1;

        return c;
    }

    public Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        //updating the heights after rotating and balancing the tree;
        p.height = Math.max(height(p.left),height(p.right)) + 1;
        c.height = Math.max(height(c.left),height(c.right)) + 1;

        return p;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
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

