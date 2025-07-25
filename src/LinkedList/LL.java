package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size = 0;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }

        size--;
        return val;
    }
    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        int val = tail.value;
        Node ptr = head;
        while (ptr.next != tail){
            ptr = ptr.next;
        }
        tail = ptr;
        tail.next = null;

        size--;
        return val;
    }
    public int delete(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast();
        }
        Node temp = head;
        int x = 0;
        while (x != index -1){
            temp = temp.next;
            x++;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;

        return val;
    }
    // Insert using Recursion..
    public void insertRec(int val,int index){
        head = insertRec( val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if (index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val,index--,node.next);
        return node;
    }

    public void insert(int index, int val){
        if (index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertEnd(val);
            return;
        }
        Node temp = head;
        Node ptr = new Node(val);

        int x = 0;
        while(x != index -1){
            temp = temp.next;
            x++;
        }
        ptr.next = temp.next;
        temp.next = ptr;

        size++;
    }
    public void insertEnd(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;

    }
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }

        size++;
    }
    public boolean hasCycle(Node head){
        // In cycle questions will always use two pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next;
            if (fast == slow){
                return true;
            }
     }
        return false;
    }

    public int lengthOfCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast){
                    int length = 0;
                    do {
                        slow = slow.next;
                        length++;
                    }while (slow != fast);
                    return length;
                }
        }
        return 0;
    }
    public Node headOfCycle(Node head){
        Node slow = head;
        Node fast = head;
        int length = 0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
              if (fast == slow){
                 length = lengthOfCycle(head);
                break;
            }
        }
        if (length == 0){
            return null;
        }
        // find the starting NODE of cycle
        Node f = head;
        Node s = head;

        while (length > 0 ){
            f = f.next;
            length--;
        }
        while (f != s){
            f = f.next;
            s = s.next;
        }

        return s;

    }
    public Node find(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    // Recursive Reversal Of LL:
    public void reverse(Node node){
        if (node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    // inplace reversal of LL:
    public Node rev(Node node){
        if(head == null){
            return head;
        }
        Node prev = null;
        Node pres = head;
        Node front = pres.next;
        while (pres != null){
            pres.next = prev;
            prev = pres;
            pres = front;
            if (front != null){
                front = front.next;
            }
        }
        return prev;
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
