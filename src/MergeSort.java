import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
       int[] ans =  mergesort(arr);
        System.out.println(Arrays.toString(ans));       // Original Array was not modified.
                                                        // New Array was created and returned

    }
    static int[] mergesort(int[] arr){
        if (arr.length ==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);

    }

     static int[] merge(int[] left, int[] right) {
        int i =0;
        int j=0;
        int k =0;
        int[] mix = new int[left.length + right.length];

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
         // copy the remaining elements
         while (i < left.length){
             mix[k] = left[i];
             i++;
             k++;
         }
         while (j < right.length){
             mix[k] = right[j];
             j++;
             k++;
         }
         return mix;
     }
}
