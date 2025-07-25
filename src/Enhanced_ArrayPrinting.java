import java.util.*;

public class Enhanced_ArrayPrinting {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        Scanner sc = new Scanner(System.in);
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                arr[r][c]= sc.nextInt();

            }

                                             }
           for(int[] a  : arr){
               System.out.println(Arrays.toString(arr));
           }
    }
}
