
import java.util.*;



public class RotateArrayLeft {


    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1};
        int d = 9;
        d= d%arr.length;
        int ind = arr.length - d;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,ind-1);
        reverse(arr,ind,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int[] arr , int s, int e){
        while (s < e){
            swap(arr,s++,e--);
        }
    }
    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }




}

