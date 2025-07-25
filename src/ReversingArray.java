import java.util.Arrays;
import java.util.Scanner;

public class ReversingArray {
    public static void main(String[] args) {
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));


    }
    static void reverse (int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            swap(arr, start,end);
            start++;
            end--;
                                     }
    }
    static void swap(int[] arr,int ind1,int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;

    }
}
