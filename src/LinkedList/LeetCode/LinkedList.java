package LinkedList.LeetCode;

import java.util.List;

public class LinkedList {
    public ListNode head;
    private ListNode tail;
    private int size;
    public LinkedList(){
        this.size = 0;
    }

    public void display(){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public static ListNode merge(LinkedList first, LinkedList second){
        ListNode f = first.head;
        ListNode s = second.head;

        LinkedList ans = new LinkedList();

        while(f != null && s != null){
            if (f.val < s.val){
                ans.insertEnd(f.val);
                f = f.next;
            }else{
                ans.insertEnd(s.val);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertEnd(f.val);
            f = f.next;
        }

        while (s != null){
            ans.insertEnd(s.val);
            s = s.next;
        }

        return ans.head;
    }
    public int deleteFirst(){
        int val = head.val;
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
        int val = tail.val;
        ListNode ptr = head;
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
        ListNode temp = head;
        int x = 0;
        while (x != index -1){
            temp = temp.next;
            x++;
        }
        int val = temp.next.val;
        temp.next = temp.next.next;

        return val;
    }
    // Insert using Recursion..
    public void insertRec(int val,int index){
        head = insertRec( val,index,head);
    }
    private ListNode insertRec(int val, int index, ListNode node){
        if (index == 0){
            ListNode temp = new ListNode(val,node);
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
        ListNode temp = head;
        ListNode ptr = new ListNode(val);

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
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;

        size++;

    }
    public void insertLast(ListNode head,int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        ListNode ptr = head;
        while (ptr.next != null){
            ptr = ptr.next;
        }
        ListNode node = new ListNode(val);
        ptr.next= node;
        node.next = null;

    }
    public void insertFirst(int value){
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }

        size++;
    }
    public boolean hasCycle(ListNode head){
        // In cycle questions will always use two pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

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
    public ListNode headOfCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
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
        ListNode f = head;
        ListNode s = head;

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
    public ListNode findmiddle(ListNode head){
        int length = lengthOfCycle(head);
        int pos = length / 2;
        ListNode temp = head;
        int x = 0;
        while(x != pos){
            temp = temp.next;
            x++;
        }
        return temp;
    }
    public  ListNode rev(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode front = pres.next;
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
    public static ListNode getmid(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }

        return s;
    }
//    public ListNode sortList(ListNode head){
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode mid = getMid(head);
//        ListNode left = sortList(head);
//        ListNode right = sortList(mid);
//
//       // return merge(left,right);
//    }
    public ListNode getMid(ListNode head){
        ListNode midPrev = null;
        while (head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    public ListNode find(int value){
        ListNode node = head;
        while (node != null){
            if (node.val == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public int pairSum(ListNode head) {
        ListNode secondHead = rev(getmid(head));
        int sum = 0;
        while (secondHead != null && secondHead.next != null){
            sum = Math.max(sum,head.val + secondHead.val);
            head = head.next;
            secondHead = secondHead.next;
        }
        return sum;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int value){
            this.val = value;
        }
        public ListNode(int value, ListNode next){
            this.val = value;
            this.next = next;
        }
    }
}
