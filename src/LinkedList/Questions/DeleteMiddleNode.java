package LinkedList.Questions;

import LinkedList.LeetCode.LinkedList;

import java.util.HashSet;

public class DeleteMiddleNode extends LinkedList{
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertEnd(1);
        list1.insertEnd(2);
        list1.insertEnd(3);
        list1.insertEnd(4);
        list1.insertEnd(5);
        list1.insertEnd(6);
        list1.insertEnd(7);
        list1.insertEnd(8);
        list1.display();

        list1.head = swapPairs(list1.head);
        list1.display();




    }
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;

        while (f != null || f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = s.next;

        return head;
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ptr = head;
        head = head.next;
        ListNode prev = null;
        while (ptr != null && ptr.next != null){

            ListNode upcoming = ptr.next.next;
            ptr.next.next = ptr;
            ptr.next = upcoming;
            prev = ptr;
            ptr = ptr.next;

            if (prev != null){
                prev.next = (ptr != null && ptr.next != null) ? ptr.next : ptr;
            }
        }
        return head;
    }



}
