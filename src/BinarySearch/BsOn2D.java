package BinarySearch;
import java.util.*;
public class BsOn2D {
    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11,15},
                       {2,5,8,12,19},
                       {3,6,9,16,22},
                       {10,13,14,17,24},
                       {18,21,23,26,30}};

        int target = 5;
    }

    public static boolean searchMatrix(int[][] mat, int tar) {
        int row = 0;
        int col = mat[0].length - 1;

        while (row < mat.length && col >= 0){
            if (mat[row][col] == tar) return true;
            else if (mat[row][col] > tar) col--;
            else{
                row++;
            }
         }
        return false;
    }
}
