package LinkedList.Questions;

public class Linkedlist {
    public Node head;
    private Node tail;
    private int size;
    public Linkedlist(){
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
    public static Linkedlist merge(Linkedlist first, Linkedlist second){
        Node f = first.head;
        Node s = second.head;

        Linkedlist ans = new Linkedlist();

        while(f != null && s != null){
            if (f.value < s.value){
                ans.insertEnd(f.value);
                f = f.next;
            }else{
                ans.insertEnd(s.value);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertEnd(f.value);
            f = f.next;
        }

        while (s != null){
            ans.insertEnd(s.value);
            s = s.next;
        }

        return ans;
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

    public class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
