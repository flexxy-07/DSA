package LinkedList;

public class DLL {
   private Node head;

    public DLL(){
        this.head = null;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

    }
    public void insert(int after,int val){
        Node p = find(after);
        if (p == null){
            System.out.println("does not exist");
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null){
            node.next.prev = node;
        }
    }
    public void insertEnd(int val){
        Node node =  new Node(val);
        Node temp = head;
        node.next = null;
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;

    }
    public void display(){
        Node ptr = head;
        while (ptr != null){
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }
        System.out.println("END");

    }
    public void displayRev(){
        Node ptr = head;
        Node last = null;
        while (ptr != null){
            last = ptr;
            ptr = ptr.next;

        }
        while (last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }
    public Node find(int val){
        Node node = head;
        while (node!=null){
            if (node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    private class Node{
        int val;
        Node next;
        Node prev;
        Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
