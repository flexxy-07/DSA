package DynamicProgramming;
import java.util.*;

// Url : https://leetcode.com/problems/unique-paths/description/

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int[][] visited = new int[m][n];
        for (int[] row : visited){
            Arrays.fill(row, -1);
        }

        System.out.println(Pathfinder(m, n, visited));
    }

    public static int Pathfinder(int row, int col, int[][] visited) {
        if (row == 1 || col == 1) {
            return 1;
        }
        if (visited[row - 1][col - 1] != -1) return visited[row - 1][col - 1];
        int down = Pathfinder(row - 1, col, visited);
        int right = Pathfinder(row, col - 1, visited);


        return visited[row - 1][col - 1] = down + right;
    }
}