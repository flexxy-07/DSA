public class FloornCeiling {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 4;
        int ans = search(arr, target);
        System.out.println(ans);


    }

    static int search(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid])
                start = mid + 1;
            else if (target < arr[mid])
                end = mid - 1;
            else
                return mid;

        }
        return end;  // Ceiling = Start
                     // Floor  = end
    }
}













