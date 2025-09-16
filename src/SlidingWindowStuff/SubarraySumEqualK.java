package SlidingWindowStuff;
import java.util.*;

public class SubarraySumEqualK {
    public static void main(String[] args) {
        int[] arr = {1};
        int k = 0;
        System.out.println(subarraySum(arr, k));

    }

    public static int subarraySum(int[] arr, int k) {
       int ans1 = lessthan(arr,k);
       int ans2 = lessthan(arr,k - 1);
       return ans1 - ans2;
    }
    private static int lessthan(int[] arr, int goal){
        if (goal <= 0) return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        while (r < arr.length) {
            sum += arr[r];
            while (sum > goal) {
                sum -= arr[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}