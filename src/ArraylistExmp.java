import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class ArraylistExmp {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(10);


        arr.add(2);
        arr.add(5);
        arr.add(69);
        arr.add(99);
        arr.add(19);
        arr.add(98);
  //        System.out.println(arr.contains(5));
 //        System.out.println(arr);
        arr.set(0,96);
 //       System.out.println(arr);
        arr.set(1,69);
 //        System.out.println(arr);
        for (int i = 0; i < 6; i++) {
            System.out.print(arr.get(i)+" ");
                                    }





    }
}
