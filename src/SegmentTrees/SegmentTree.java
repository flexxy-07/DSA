package SegmentTrees;

public class SegmentTree {
    private Node root;

    public SegmentTree(int[] arr){
        this.root = constructTree(arr,0,arr.length -1);
    }
     private Node constructTree(int[] arr, int start, int end){
        if (start == end){
           // leaf node
           Node leaf = new Node(start,end);
           leaf.data = arr[start];
           return leaf;
        }
        Node node = new Node(start,end);
        int mid = (start + end) / 2;

        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr,mid + 1,end);

        node.data = node.left.data + node.right.data;
        return node;
     }

     // query function
     public int query(int queryStartIndex, int queryEndIndex){
        return this.query(this.root,queryStartIndex,queryEndIndex);
     }

     private int query(Node node, int queryStartIndex, int queryEndIndex){
        if (node.startInterval >= queryStartIndex && node.endInterval <= queryEndIndex){
            // node is completely lying inside the query
            return node.data;
        }
        else if (node.startInterval > queryEndIndex || node.endInterval < queryStartIndex){
            // it lies completely outside
            return 0;
        }
        else{
            return this.query(node.left,queryStartIndex,queryEndIndex) + this.query(node.right,queryStartIndex,queryEndIndex);
        }
     }

     // update
    public void update(int index, int value){
        this.root.data = update(this.root,index,value);
    }
    public int update(Node node,int index, int value){
        if (index >=node.startInterval && index <= node.endInterval ){
            if (index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }else{
                int leftAns = update(node.left,index,value);
                int rightAns = update(node.right,index,value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

     public void display(){
        display(this.root);
     }

     private void display(Node node){
        String str = "";

        if (node.left != null){
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        }else{
            str = str + "No left child";
        }
        // for current Node
            str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

         if (node.right != null){
             str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
         }else{
             str = str + "No right child";
         }

         System.out.println(str + '\n');

         // calling the Recursion
         if (node.left != null){
             display(node.left);
         }
         if (node.right != null){
             display(node.right);
         }

     }

    public class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
             this.startInterval = startInterval;
             this.endInterval = endInterval;
        }
    }
}
