package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Subseq(0,arr,new ArrayList<>());
    }
    private static void Subseq(int index, int[] arr, List<Integer> list){
        if (index  > arr.length - 1){
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        Subseq(index + 1, arr, list);
        list.remove(list.size() - 1);
        Subseq(index +1 ,arr,list);
    }
}
