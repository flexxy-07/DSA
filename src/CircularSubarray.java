public class CircularSubarray {
    public static void main(String[] args) {
        int[] arr = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println(circularSubarraySum(arr));

    }
    static int circularSubarraySum(int arr[]) {
        int totalsum = 0;

        for (int i = 0; i < arr.length ; i++) {
            totalsum+=arr[i];
        }
        int normalsum = maxKadane(arr);
        int min = minKadane(arr);

        int circular = totalsum - min;

        if(min == totalsum){
            return normalsum;
        }
        return Math.max(normalsum,circular);




    }

        static int maxKadane(int[] arr){
        int curr = arr[0];
        int max = arr[0];

       for (int i = 1; i < arr.length; i++) {
           curr = Math.max(arr[i] , curr + arr[i]);
           max = Math.max(max , curr);
       }
       return max;
   }
    static int minKadane(int[] arr){
        int curr = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curr = Math.min(arr[i] , curr + arr[i]);
            min = Math.min(min , curr);
        }
        return min;
    }

}
