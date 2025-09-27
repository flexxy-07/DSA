package DynamicProgramming;
import java.util.*;

public class Triangle {
    public static void main(String[] args) {

    }

    // Memoization = TLE
    public static int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int[][] store = new int[tri.size()][tri.size()];
        for (int j = 0; j < n; j++) {
            store[n - 1][j] = tri.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--){
            for (int j = i; j >= 0 ; j--) {
                int down = tri.get(i).get(j) + store[i + 1][j];
                int diagonal = tri.get(i).get(j) + store[i + 1][j + 1];

                store[i][j] = Math.min(down , diagonal);
            }
        }
        return store[0][0];

    }
//    private static int minPathFind(List<List<Integer>> triangle, int[][] store, int row, int col){
//        if (row == triangle.size() - 1){
//            return triangle.get(row).get(col);
//        }
//        if (store[row][col] != -1) return store[row][col];
//
//        int down = minPathFind(triangle, store, row + 1, col);
//        int diagonal = minPathFind(triangle, store, row + 1, col + 1);
//
//        return store[row][col] = triangle.get(row).get(col) + Math.min(down , diagonal);
//    }

    // Tabulation
//    private static int minPathFind(){
//
//    }
}
