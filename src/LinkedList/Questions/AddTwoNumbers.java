package LinkedList.Questions;

import LinkedList.LeetCode.LinkedList;
import java.util.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;

public class AddTwoNumbers extends LinkedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertEnd(5);
        l1.insertEnd(3);
        l1.insertEnd(1);
        l1.insertEnd(2);
        l1.insertEnd(5);
        l1.insertEnd(1);
        l1.insertEnd(2);
        l1.display();
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(l1.head)));

    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return new int[]{-1,-1};
        }

        int first = -1;
        int last = -1;
        int prevC = -1;
        int min = Integer.MAX_VALUE;
        int position =2;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        while (next != null){
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)){
                if (first == -1){
                    first = position;
                }else{
                    min = Math.min(min,position - prevC);
                    last = position;
                }
                prevC = position;
            }
            prev = curr;
            curr = next;
            next = next.next;
            position++;
        }
        if (first == -1 || last == -1){
            return new int[]{-1,-1};
        }
        return new int[]{min,last -first};
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            StringBuilder num1 = new StringBuilder("");
            StringBuilder num2 = new StringBuilder("");
            ListNode temp = l1;
            while (temp != null){
                num1.append(temp.val);
                temp = temp.next;
            }

            temp = l2;
             while (temp != null){
            num2.append(temp.val);
            temp = temp.next;
        }
             num1 = num1.reverse();
             num2 = num2.reverse();

        BigInteger big1 = new BigInteger(num1.toString());
        BigInteger big2 = new BigInteger(num2.toString());
        BigInteger sum = big1.add(big2);

             ListNode dummy = new ListNode(-1);
             ListNode tail = dummy;
             if (sum.equals(BigInteger.ZERO)){
                 return new ListNode(0);
             }
             while (sum.compareTo(BigInteger.ZERO) > 0){
                 int l = sum.mod(BigInteger.TEN).intValue();
                 tail.next = new ListNode(l);
                 tail = tail.next;
                 sum = sum.divide(BigInteger.TEN);
             }
             return dummy.next;
    }

}

