package LinkedList.Questions;

import LinkedList.LeetCode.LinkedList;

public class ReOrderList extends LinkedList {
    public static void main(String[] args) {

    }
     public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode hf = head;
        ListNode hs = rev(getmid(head));

        while (hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }
    }
    public  ListNode rev(ListNode node){
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

}
