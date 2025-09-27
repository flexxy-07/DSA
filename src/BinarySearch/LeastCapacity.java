package BinarySearch;
import java.util.*;
public class LeastCapacity {
    public static void main(String[] args) {
    int[] arr = {1,2,3,1,1};
        System.out.println(shipWithinDays(arr , 4));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int[] sumMax = sumAndMax(weights);
        int start = sumMax[1];
        int end = sumMax[0];

        while (start < end){
            int midCap = start + (end - start) / 2;
            if (isThis(weights, midCap, days)){
                end = midCap;
            }else{
                start = midCap + 1;
            }
        }
        return start;

    }
    private static boolean isThis(int[] arr, int cap, int reqDays){
        int load = 0;
        int day = 1;

        for (int val : arr){
            if (load + val > cap){
                day++;
                load = val;
            }else{
                load += val;
            }
        }
        return day <= reqDays;

    }
    private static int[] sumAndMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int val : arr){
            sum += val;
            if (val > max) max = val;
        }
        return new int[]{sum, max};
    }
}
