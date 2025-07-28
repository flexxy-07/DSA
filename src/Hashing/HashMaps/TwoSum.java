package Hashing.HashMaps;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
    }
    public int[] twoSum(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
                int complement = target - arr[i];
                if (map.containsKey(target - arr[i])){
                   return new int[]{map.get(complement),i};
                }
                map.put(arr[i],i );
        }
        return new int[]{-1, -1};
    }
    private static boolean hastwoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr){
            int complement = target - val;
            if (set.contains(complement)){
                return true;
            }
            set.add(val);
        }
        return false;
    }
}
