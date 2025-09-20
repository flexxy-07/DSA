package BinarySearch;
import java.util.*;
public class MBouquets {
    public static void main(String[] args) {

    int[] arr = {1,2,4,9,3,4,1};
        System.out.println((minDays(arr,2,2)));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int[] arr = minAndMax(bloomDay);
        int min = arr[0];
        int max = arr[1];
        int start = min;
        int end = max;

        while (start < end){
            int mid = start + (end - start) / 2;
            if (isPossible(bloomDay, mid, m, k)){

                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static boolean isPossible(int[] arr, int day, int m, int k){
        int count = 0;
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) count++;
            else{
                val += (count / k);
                count = 0;
            }
        }
        val += (count / k);
        return val >= m;
    }

    private static int[] minAndMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int val : arr){
            if (val > max) max = val;
            if (val < min) min = val;
        }
        return new int[]{min,max};
    }
}
