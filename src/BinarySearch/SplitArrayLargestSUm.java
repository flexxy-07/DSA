package BinarySearch;
import java.util.*;
public class SplitArrayLargestSUm {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        System.out.println(splitArray(arr, k));

    }
    public static int splitArray(int[] arr, int k) {
        if (k > arr.length) return -1;
        int[] bogus = maxElemAndSum(arr);
        int start = bogus[0];
        int end = bogus[1];

        while (start < end){
            int mid = start + (end - start) / 2;
            if (Possible(arr, mid) > k){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    private static int Possible(int[] arr, int currSum){
        int part = 1;
        int sum = 0;

        for (int val : arr){
            if (sum + val <= currSum){
                sum += val;
            }else{
                part++;
                sum = val;
            }
        }
        return part;
    }
    private static int[] maxElemAndSum(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int val : arr){
            if (val > max) max = val;
            sum += val;
        }
        return new int[]{max,sum};
    }
}
