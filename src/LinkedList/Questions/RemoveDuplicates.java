package LinkedList.Questions;

public class RemoveDuplicates extends Linkedlist {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.insertFirst(3);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);
        list.display();
        list.head = deleteDuplicates(list.head);
        list.display();


    }
    static Node deleteDuplicates(Node head){
        if (head == null){
            return null;
        }
        Node temp = head;
        while ( temp != null && temp.next != null){
            if (temp.value == temp.next.value){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
   }

}
