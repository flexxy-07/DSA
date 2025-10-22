package DynamicProgramming;
import java.util.*;
// Url : https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqSubSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(canPartition(arr));
    }
    public static boolean canPartition(int[] arr) {
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        if (sum % 2 != 0) return false;
        Boolean[][] check = new Boolean[arr.length][sum];

        return canDivide(arr, arr.length - 1, sum / 2,check);

    }
    private static boolean canDivide(int[] arr, int index, int target, Boolean[][] check){
        if (target == 0) return true;
        if (index < 0) return false;
        if (index == 0 && arr[0] == target) return true;

        if (check[index][target] != null) return check[index][target];

        boolean pick = false;
        if (target >= arr[index]){
             pick = canDivide(arr, index - 1, target - arr[index], check);
        }

        boolean notPick = canDivide(arr, index - 1, target, check);

        return check[index][target] = pick || notPick;

    }


}
