package Graphs;
import java.util.*;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] checked = new boolean[m][n];
        int isLands = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!checked[row][col] && grid[row][col] == '1'){
                    isLands++;
                    levelOrder(grid, checked, row, col, m , n);
                }
            }
        }
        return isLands;
    }
    private void levelOrder(char[][] grid, boolean[][] checked, int row, int col, int m , int n){
        Queue<int[]> queue = new ArrayDeque<>();
        checked[row][col] = true;
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int r = arr[0];
            int c = arr[1];

            // The below method is for 8 direction which include the diagonals element too.
//            for (int rows = -1; rows <= 1 ; rows++) {
//                for (int cols = -1; cols <= 1; cols++) {
//                    int neighRow = r + rows;
//                    int neighCol = c + cols;
//
//                    if (neighRow >= 0 && neighRow < m && neighCol >= 0 && neighCol < n
//                        && grid[neighRow][neighCol] == '1' && !checked[neighRow][neighCol]
//                    ){
//                        checked[neighRow][neighCol] = true;
//                        queue.add(new int[]{neighRow, neighCol});
//                    }
//                }
//            }
            if (r - 1 >= 0 && grid[r - 1][c] == '1' && !checked[r - 1][c]) {
                checked[r - 1][c] = true;
                queue.add(new int[]{r - 1, c});
            }


            if (r + 1 < m && grid[r + 1][c] == '1' && !checked[r + 1][c]) {
                checked[r + 1][c] = true;
                queue.add(new int[]{r + 1, c});
            }


            if (c - 1 >= 0 && grid[r][c - 1] == '1' && !checked[r][c - 1]) {
                checked[r][c - 1] = true;
                queue.add(new int[]{r, c - 1});
            }


            if (c + 1 < n && grid[r][c + 1] == '1' && !checked[r][c + 1]) {
                checked[r][c + 1] = true;
                queue.add(new int[]{r, c + 1});
            }
        }

    }
}
