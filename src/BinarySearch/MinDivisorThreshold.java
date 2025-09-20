package BinarySearch;
import java.util.*;
public class MinDivisorThreshold {
    public static void main(String[] args) {
        int[] arr = {44,22,33,11,1};
        int thresh = 5;
        System.out.println(smallestDivisor(arr, thresh));

    }
    public static int smallestDivisor(int[] arr, int thresh) {
        int[] minMax = minAndMax(arr);
        int max = minMax[1];
        int start = 1;
        int end = max;

        while (start < end){
            int mid = start + (end - start) / 2;
            if (isPossible(arr, mid, thresh)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    private static boolean isPossible(int[] arr, int div, int thresh){
        int sum = 0;
        for(int val : arr){
            sum += Math.ceil((double) val / div);
         //   System.out.println(sum);
        }
        return sum <= thresh;

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
