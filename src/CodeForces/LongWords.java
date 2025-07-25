package CodeForces;

import java.util.*;


public class LongWords {
    public static void main(String[] args) { // gonna attempt the problem tomorrow.......
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (m  <  arr[i]){
                list.add(i + 1);
            }
        }
        if (list.size() == 0){
            System.out.println(size);
        }else{
            System.out.println(list.get(list.size() - 1 ));
        }

    }


}