package Recursion;
import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] can = {2,5,2,1,2};
    //    int target =  5;
        int k = 3;
        int n = 9;
//        System.out.println(combinationSum3(k,n));
        int[] arr = {1,2,3};
        int target = 4;
        List<List<Integer>> ans = new ArrayList<>();
//        int count = dynamicSum(arr,target,ans,new ArrayList<>(),0,0);
//        System.out.println(ans);
//        System.out.println(count);
        System.out.println(combinationSum4(arr,target));
    }
    public static int combinationSum4(int[] arr, int target) {
        int[] counts = new int[arr.length + 1];
        Arrays.fill(counts, -1);
        int count = dynamicSum(arr,counts,target,0,0);
        return count;

    }
    private static int dynamicSum(int[] arr,int[] counts,int target,int sum, int index){
        if (sum == target){
            return 1;
        }
        if (sum > target) return 0;
        if (counts[index] != -1) return counts[index];
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            count += dynamicSum(arr,counts, target, sum, index);
            sum -= arr[i];
            count += dynamicSum(arr,counts,target, sum, index + 1);
        }
        return count;
    }

    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> ans = new ArrayList<>();
        allPossibles(k,n,ans,new ArrayList<>(),0,1);
        return ans;
    }
    public static List<List<Integer>> combinationSum2(int[] can, int target) {
        Arrays.sort(can);
        List<List<Integer>> ans = new ArrayList<>();
        Validator(can,target,ans,new ArrayList<>(),0,0);
        return ans;

    }
    private static void Validator(int[] can, int target, List<List<Integer>> ans, List<Integer> list, int sum, int start){
        if (sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) return;

        for (int i = start; i < can.length ; i++) {
            if (i > start && can[i] == can[i - 1]) continue;

            list.add(can[i]);
            sum += can[i];
            Validator(can,target,ans,list,sum,i + 1);
            sum -= can[i];
            list.remove(list.size() - 1);
        }
    }
    private void allPossibles(int k, int n, List<List<Integer>> ans, List<Integer> list, int sum, int start){
        if (sum == n && list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if (sum > n) return;

        for (int i = start; i <= 9 ; i++) {
            list.add(i);
            sum += i;
            allPossibles(k,n,ans,list,sum,i + 1);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }


}
