//package Recursion;
//import java.util.*;
//
//
//public class Permutations2 {
//    public static void main(String[] args) {
//        int[] arr = {1,1,2};
//        System.out.println(permuteUnique(arr));
//
//    }
//    public static List<List<Integer>> permuteUnique(int[] arr) {
//        List<List<Integer>> ans = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : arr){
//            set.add(num);
//        }
//        Recurse(arr,ans,new ArrayList<>(),new boolean[arr.length],set);
//        return ans;
//    }
//    private static void Recurse(int[] arr, List<List<Integer>> ans, List<Integer> list, boolean[] map, HashSet<Integer> set){
//        if (list.size() == arr.length){
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (!map[i] && set.contains(arr[i])){
//                map[i] = true;
//                list.add(arr[i]);
//                set.remove(arr[i]);
//                Recurse(arr,ans,list,map,set);
//                map[i] = false;
//                list.remove(list.size() - 1);
//                set.add(arr[i]);
//            }
//        }
//    }
//}
