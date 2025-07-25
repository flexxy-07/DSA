import java.util.Arrays;

public class MergeSortInplace {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergesortInplace(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergesortInplace(int[] arr, int s, int e){
        if (e-s ==1){
            return ;
        }
        int mid = (s+e)/2;
        mergesortInplace(arr,0,mid);
        mergesortInplace(arr,mid,e);

         MergeInPlace(arr,s,mid,e);

    }

    static void MergeInPlace(int[] arr,int s,int mid,int e) {
        int i =s;
        int j=mid;
        int k =0;
        int[] mix = new int[e-s];

        while (i < mid && j < e){
            if (arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
