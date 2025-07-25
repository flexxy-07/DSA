public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {2,1,-1};
        System.out.println(pivot(arr));

    }
    static int pivot(int[] arr){
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        int ans = -1;
        for (int i = 0; i < prefix.length; i++) {
            int left = i == 0 ? 0 : prefix[i -1];
            int right = prefix[prefix.length-1] - prefix[i];

            if (left == right){
                return i;
            }
        }

        return -1;
    }
}
