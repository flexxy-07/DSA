package DynamicProgramming;
import java.util.*;
public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] mat = {{2,1,3}, {6,5,4}, {7,8,9}};
        System.out.println(minFallingPathSum(mat));
    }
    public static int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int[][] paths = new int[n][n];

        for (int i = 0; i < n; i++) {
            paths[n - 1][i] = mat[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                int left = Integer.MAX_VALUE;
                int down = 0;
                int right = Integer.MAX_VALUE;

                if (j > 0){
                    left = mat[i][j] + paths[i + 1][j - 1];
                }

                down = mat[i][j] + paths[i + 1][j];

                if (j < n - 1){
                    right = mat[i][j] + paths[i + 1][j + 1];
                }
                int ans = Math.min(left , down);
                paths[i][j] = Math.min(ans , right);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min , paths[0][i]);
        }

        return min;
    }
    private static int minPath(int[][] mat, int row, int col, int[][] paths, int n){
        if (row == n - 1){
            return mat[row][col];
        }


        if (paths[row][col] != -1) return paths[row][col];


        int left = Integer.MAX_VALUE;
        int down = 0;
        int right = Integer.MAX_VALUE;

        if(col > 0){
            left = mat[row][col] +  minPath(mat, row + 1, col - 1, paths, n);
        }
        down = mat[row][col] + minPath(mat, row + 1, col, paths, n);

        if (col < n - 1){
            right = mat[row][col] + minPath(mat, row + 1, col + 1, paths, n);
        }
        int ans = Math.min(left,down);

        return paths[row][col] = Math.min(ans , right);
    }

}
