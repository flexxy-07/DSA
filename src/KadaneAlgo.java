import java.util.Arrays;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7, 8};
        System.out.println((maxSum(arr)));

    }
    // max sum of subarray
    static int maxSum(int[] arr){
        int currSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i],currSum + arr[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
    // sum with the subarray itself(including indices)
//    static int maxSumWithIndices(int[] arr){
//        int start =0, s =0, e =0;
//        int currSum = arr[0];
//        int maxSum = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//
//
//        }
//    }

}
