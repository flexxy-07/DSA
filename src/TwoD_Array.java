import java.util.Arrays;
import java.util.Scanner;

public class TwoD_Array {
    public static void main(String[] args) {
 //       int [][] arr = new int[3][];
//        int[][] rn = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//
//
//
//
//        };
//        System.out.println(Arrays.toString(rn));
        int[][] arr = new int[3][3];
        Scanner sc = new Scanner(System.in);

 //       System.out.println(arr.length); // It will give the number of rows in the array.
        for (int row = 0; row < arr.length; row++)         {
            for (int col = 0; col < arr[row].length;col++) {
                arr[row][col] = sc.nextInt();
            }

                                                            }
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
          //      System.out.print(arr[row][col] +" ");



            }
           System.out.println(Arrays.toString(arr[row]));

                
            }
            
        }


        }


