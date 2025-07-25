import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {5,1,1}; // the output should be  1 1 5
        int left =0;
        int right = arr.length -1;
        int i = right -1;
        while (i >=0 && arr[i] >= arr[i+1]){
            i--;
        }
        if (i>=0){
            while (arr[right] <= arr[i]){
                right--;
            }
            swap(arr,i,right);
        }
        int s = i+1;
        int e = arr.length-1;
        while (s < e){
            swap(arr,s++,e--);
        }

        System.out.println(Arrays.toString(arr));

    }
    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
