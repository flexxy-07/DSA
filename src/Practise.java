import javax.print.attribute.standard.SheetCollate;
import java.awt.image.ImageProducer;
import java.sql.SQLOutput;
import java.util.*;

public class Practise {

}
class LinkedL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();
        list.add(5);
        list.add("sumit");
        list.add('a');

        System.out.println(list);
    }
}
class Vec {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        vec.add(10);
        vec.add(100);
        vec.add(110);
        vec.add(69);
        vec.add(2);
        vec.add(1 , 99);
        vec.remove(Integer.valueOf(110));
        System.out.println(vec);
    }
}

class Que {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(69);
        queue.add(59);
        queue.add(88);
        queue.add(65);
        queue.add(10);

        System.out.println(queue.peek());

    }
}

class Sort {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(30);
        set.add(90);
        set.add(40);
        set.add(50);

        //System.out.println("Sorted set : " + set);

        SortedSet<Integer> head = set.headSet(30);
        System.out.println("Headset less than 30 : " + head);

        head.add(29);
        System.out.println(head);
    }
}

class Mapp {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1 , "Robot");
        map.put(2 , "Evil");
        map.put(3 , "Runtime");
        map.put(4 , "Dynamic");

        for(Map.Entry<Integer , String> set : map.entrySet()){
            System.out.println("Roll No. : " + set.getKey() + "," + "Name : " + set.getValue());
        }
    }
}

class Questions {
    public static void main(String[] args) {
        //
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(60);
        list.add(69);
        list.add(9);
        list.add(69);
        list.add(70);
        list.add(99);
        list.add(100);
        list.add(70);

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : list){
            map.put(val , map.getOrDefault(val , 0) + 1);
        }
      //  System.out.println("Before List :" + list);
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) > 1){
                map.put(list.get(i), map.get(list.get(i)) - 1);
                list.remove((Integer)list.get(i));
             //   System.out.println(list);

            }
        }
//        System.out.println();
//        System.out.println("After List :" + list);
        String s = "pinnacle";
        System.out.println(s);
        s = reverseStr(s);
        System.out.println(s);
    }

    public static String reverseStr(String s){

        Stack<Character> stk = new Stack<>();
        for (char ch : s.toCharArray()){
            stk.push(ch);
        }
        StringBuilder str = new StringBuilder();
        while (!stk.isEmpty()){
            str.append(stk.pop());
        }
        int[] arr = {2,5,4,3};
        return str.toString();

    }


}