package LinkedList.Questions;

public class MergeList extends Linkedlist {
    public static void main(String[] args) {
        Linkedlist first = new Linkedlist();
        Linkedlist second = new Linkedlist();

        first.insertEnd(1);
        first.insertEnd(2);
        first.insertEnd(4);
        first.insertEnd(25);
        first.insertEnd(89);
        second.insertEnd(1);
        second.insertEnd(3);
        second.insertEnd(4);

        first.display();
        second.display();

        Linkedlist ans = merge(first,second);

        ans.display();


    }

}
