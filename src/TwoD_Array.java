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

    class P{
        public static void main(String[] args) {
            String s = "A";
            int numRows = 1;
            System.out.println(convert(s,numRows));
        }
        public static String convert(String s, int numRows) {
            int rows = numRows;
            int cols = s.length();
            char[][] board = new char[rows][cols];
            boolean up = false;
            int row = 0;
            int col = 0;
            int k = 0;

            while (k < s.length()){
                board[row][col] = s.charAt(k++);
                if (up){
                    row--;
                    col++;
                }
                else {
                    row++;
                }

                if (row == rows - 1) up = true;
                else if (row == 0) up = false;

            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] != '\u0000'){
                        str.append(board[i][j]);
                    }
                }
            }
            return str.toString();
        }
    }


