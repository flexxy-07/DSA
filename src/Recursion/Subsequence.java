package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    private static int count =0;
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,6};
//        Subseq(0,arr,new ArrayList<>());
        targetSumSubSeq(arr,0,new ArrayList<>(),0, 4);
        System.out.println(count);
    }
    // Print all the subsequences
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
    // print the subsequences with Target Sum

    static void targetSumSubSeq(int[] arr, int ind, List<Integer> list, int sum, int target){
        if (ind == arr.length){
            if (sum == target){
                count++;
                System.out.println(list);
            }
            return;
        }
        // Pick up the element
        list.add(arr[ind]);
        sum += arr[ind];
        targetSumSubSeq(arr,ind + 1,list,sum,target);

        // Don't pick up the element
        list.remove(list.size() - 1);
        sum -= arr[ind];
        targetSumSubSeq(arr,ind + 1,list,sum,target);
    }
}
