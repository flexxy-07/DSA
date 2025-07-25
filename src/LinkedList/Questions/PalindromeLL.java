package LinkedList.Questions;

import LinkedList.LeetCode.LinkedList;

public class PalindromeLL extends LinkedList {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getmid(head);
        ListNode secondHead = rev(mid);
        ListNode revHead = secondHead;

        while (head != null && secondHead != null){
            if (head.val != secondHead.val){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        rev(revHead);

        return head == null || secondHead == null;


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
    public ListNode rev(ListNode node){
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
