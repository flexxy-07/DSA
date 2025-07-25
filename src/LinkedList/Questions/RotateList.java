package LinkedList.Questions;

import LinkedList.LeetCode.LinkedList;

import java.util.ArrayList;

public class RotateList extends LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertEnd(7);
        list.insertEnd(9);
        list.insertEnd(6);
        list.insertEnd(6);
        list.insertEnd(7);
        list.insertEnd(8);
        list.insertEnd(3);
        list.insertEnd(0);
        list.insertEnd(9);
        list.insertEnd(5);


        list.display();
        list.head = swapNodes(list.head,5);
        list.display();


    }
    public static ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int var = list.size();
        int first = k - 1;
        int second = list.size() - k ;
        // swapping
        int proxy = list.get(first);
        list.set(first,list.get(second));
        list.set(second,proxy);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int val : list){
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        int Ncount = 1;
        while (temp.next != null) {
            temp = temp.next;
            Ncount++;
        }
        k %= Ncount;
        temp.next = head;
        int check = Ncount - k;
        ListNode prev = null;
        while (check-- > 0) {
            prev = head;
            head = head.next;
        }
        prev.next = null;

        return head;

    }

}
