public class Sliding_Window {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSum(arr,k));
    }

     static int maxSum(int[] arr, int k) {
        int windowsum =0 ;
        int maxsum = 0;
         for (int i = 0; i < k; i++) {
             windowsum+=arr[i];
         }
         maxsum = windowsum;
         for (int i = k; i < arr.length ; i++) {
             windowsum += arr[i] - arr[i - k];
             if (windowsum > maxsum){
                 maxsum = windowsum;
             }
         }
         return maxsum;
    }

}
