package Graphs;
import java.util.*;

public class RottenOranges {
    static int time;
    public static void main(String[] args) {

    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        time = 0;
        // rotten = true;
        boolean[][] vis = new boolean[m][n];
        boolean notPossible = false;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!vis[row][col] && grid[row][col] == 2){
                    Rotted(grid, vis, m, n, row , col);
                }
            }
        }
        return time - 1;

    }
    private void Rotted(int[][] grid, boolean[][] vis, int m, int n, int row, int col){
        vis[row][col] = true;
        time++;

        // Up
        if(row > 0 && grid[row - 1][col] == 1 && !vis[row-1][col]){
            Rotted(grid, vis, m, n, row - 1, col);
        }
        //Right
        if (col < n - 1 && grid[row][col + 1] == 1 && !vis[row][col + 1]){
            Rotted(grid, vis, m , n, row, col + 1);
        }
        //Down
        if (row < m - 1 && grid[row + 1][col] == 1 && !vis[row + 1][col]){
            Rotted(grid, vis, m, n, row + 1, col);
        }
        if (col > 0 && grid[row][col - 1] == 1 && !vis[row][col - 1]){
            Rotted(grid, vis, m, n, row, col - 1);
        }


    }
}

