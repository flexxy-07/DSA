import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] nums = {33,44,11,22};
        Insertion(nums);
        System.out.println(Arrays.toString(nums));



    }                                                   // INSERTION SORT
     static void Insertion(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(arr[j] < arr[j-1])
                    swap(arr,j,j-1);

            }
        }
    }
                                                        // SELECTION SORT
    static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // find the maximum index in remaining array and swap with correct index
            int last = arr.length - i -1;
            int maxIndx = getmaxIndx( arr,0,last);
            swap(arr,maxIndx,last);

            
        }
    }
    static void swap(int[] arr,int first,int second){
        int temp  = arr[first];
        arr[first] =arr[second];
        arr[second] = temp;
    }
    static int getmaxIndx(int[] arr,int start,int end){
        int max= start;
        for (int i = start; i <=end ; i++) {
            if ( arr[max] < arr[i])
                max = i;
        }
        return max;

    }
                                                                        //  BUBBLE SORT
    static void Bubble(int[] arr){
        // run the steps n-1 times;
        for (int i = 0; i < arr.length; i++) {
            // for each step, max item will come at the last respective indx
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than the previous item
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
