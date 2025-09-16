package Recursion;
import java.util.*;
// Url : https://leetcode.com/problems/permutations/

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Recurse(arr,ans,new ArrayList<>(),new boolean[arr.length]);
        return ans;
    }
    private static void Recurse(int[] arr, List<List<Integer>> ans, List<Integer> list, boolean[] map){
        if (list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map[i]){
                map[i] = true;
                list.add(arr[i]);
                Recurse(arr,ans,list,map);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }

}
