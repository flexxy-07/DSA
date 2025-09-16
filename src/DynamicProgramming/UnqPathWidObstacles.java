package DynamicProgramming;
import java.util.*;

// Url : https://leetcode.com/problems/unique-paths-ii/description/

public class UnqPathWidObstacles {
    public static void main(String[] args) {
        int[][] obs = {{0},{1}};
        int row = obs.length;
        int col = obs[0].length;
        int[][] paths = new int[row][col];
        for (int[] path : paths){
            Arrays.fill(path, -1 );
        }
        System.out.println(Blocker(obs,0,0,paths));
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int row = obs.length;
        int col = obs[0].length;
        int[][] paths = new int[row][col];
        for (int[] path : paths){
            Arrays.fill(path, -1 );
        }
        return Blocker(obs,0,0,paths);
    }
    private static int Blocker(int[][] obs, int row, int col, int[][] paths){
        if (row == obs.length - 1){
            for (int cols = col; cols < obs[0].length ; cols++) {
                if (obs[row][cols] == 1) return 0;
            }
            return 1;
        }
        if (col == obs[0].length - 1){
            for (int rows = row; rows < obs.length ; rows++) {
                if (obs[rows][col] == 1) return 0;
            }
            return 1;
        }
        if (obs[row][col] == 1){
            return 0;
        }
        if (row == obs.length - 1 && col == obs[0].length){
            return 1;
        }

        if (paths[row][col] != -1) return paths[row][col];

        int down = Blocker(obs,row + 1, col, paths);
        int right = Blocker(obs, row, col + 1, paths);

        return paths[row][col] = down + right;
    }
}
