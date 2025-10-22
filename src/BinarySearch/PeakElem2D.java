package BinarySearch;
import java.util.*;
// Url : https://leetcode.com/problems/find-a-peak-element-ii/

public class PeakElem2D {
    public static void main(String[] args) {
    int[][] mat = {{10,20,15} , {21,30,14}, {7,16,32}};
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
    public static int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length - 1;

        int row = -1;
        int col = -1;

        while (start <=  end){
            int mid = start + (end - start) / 2;
            int r = getRow(mat, mid, mat.length);

            int left = mid - 1 >= 0 ? mat[r][mid - 1] : -1;
            int right = mid + 1 <  mat[0].length ? mat[r][mid + 1] : -1;

            if (mat[r][mid] > left && mat[r][mid] > right){
                return new int[]{r, mid};
            } else if (mat[r][mid] < left) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return new int[]{row ,col};

    }
    private static int getRow(int[][] mat, int col, int n){
        int max = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0; i < n; i++) {
            if (max < mat[i][col]){
                max = mat[i][col];
                row = i;
            }
        }
        return row;
    }
}
