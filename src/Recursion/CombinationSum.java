package Recursion;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates,target,0,0,new ArrayList<>(),list);
        return list;
    }
    private static void helper(int[] arr, int target, int index, int sum, List<Integer> inner, List<List<Integer>> outer){
        if (sum == target){
            outer.add(new ArrayList<>(inner));
            return;
        }
        if (sum > target || index == arr.length){
            return;
        }
            inner.add(arr[index]);
            sum += arr[index];

            helper(arr,target,index,sum,inner,outer);
            inner.remove(inner.size() - 1);
            sum -= arr[index];
            helper(arr,target,index + 1,sum,inner,outer);
        }
    }

