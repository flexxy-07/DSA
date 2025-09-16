package DynamicProgramming;
import java.util.*;

// Url : https://leetcode.com/problems/minimum-path-sum/description/

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];
        for (int[] row : paths){
            Arrays.fill(row, -1);
        }
        return mostEfficient(grid,m - 1,n - 1,paths);

    }
    private static int mostEfficient(int[][] grid, int row, int col, int[][] paths){

        if (row < 0 || col < 0) return Integer.MAX_VALUE;
        if (row == 0 && col == 0){
            return grid[row][col];
        }

        if (paths[row][col] != -1) return paths[row][col];
        int left = mostEfficient(grid,row,col - 1,paths);
        int up = mostEfficient(grid, row - 1, col,paths);

        return paths[row][col] = grid[row][col]+ Math.min(left , up);
    }

}
