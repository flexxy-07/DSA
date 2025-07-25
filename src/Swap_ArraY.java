import java.util.Arrays;

public class Swap_ArraY {
    public static void main(String[] args) {
        int[] arr = {1,2,69,96,99};
        swap(arr,1,2);


        System.out.println(Arrays.toString(arr));

    }
    static void swap(int[] arr,int ind1,int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;



    }
}
