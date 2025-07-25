import java.awt.geom.Area;
import java.util.Arrays;

public class MinHeightDiff {
    public static void main(String[] args) {
            int[] arr = {3, 9, 12, 16, 20};
            int k =3;
        System.out.println(getmindiff(arr,k));
    }
    static int getmindiff(int[] arr, int k){
        
        Arrays.sort(arr);
        int mingap = arr[arr.length -1] - arr[0];
        for (int i = 0; i < arr.length; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k );
            int max = Math.max(arr[arr.length-1] - k, arr[arr.length -2] + k);

            mingap = Math.min(mingap,max-min);
            
        }
        return mingap;
        
    }
}
