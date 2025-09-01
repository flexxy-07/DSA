package Recursion;

public class UniquePaths3 {
// Url : https://leetcode.com/problems/unique-paths-iii/
    public static void main(String[] args) {
        int[][] grid = {{0,1},{2,0}};
        System.out.println(uniquePathsIII(grid));

    }
    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int sRow = -1;
        int sCol = -1;
        int nonObs = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1){
                    nonObs++;
                }
                if (grid[i][j] == 1){
                    sRow = i;
                    sCol = j;
                }
            }
        }
        return PathFinder(grid,visited,sRow,sCol,m,n,1,nonObs);
    }
    private static int PathFinder(int[][] maze, boolean[][] visited,int row, int col, int m, int n, int vCount, int toVisit){
        if (maze[row][col] == 2){
            return vCount == toVisit ? 1 : 0;
        }
        int count = 0;
        visited[row][col] = true;
        // down
        if( row < m - 1 && !visited[row + 1][col] && maze[row+1][col] != -1){
            count += PathFinder(maze,visited,row + 1, col,m,n,vCount + 1,toVisit);
        }
        // up
        if (row > 0 && !visited[row - 1][col] && maze[row-1][col] != -1){
            count += PathFinder(maze,visited,row - 1,col,m,n,vCount + 1,toVisit);
        }
        //left
        if (col > 0 && !visited[row][col - 1] && maze[row][col - 1] != -1){
            count += PathFinder(maze,visited,row,col - 1,m,n,vCount + 1,toVisit);
        }
        //right
        if (col < n - 1 && !visited[row][col + 1] && maze[row][col + 1] != -1){
            count += PathFinder(maze,visited,row,col + 1,m,n,vCount + 1,toVisit);
        }
        visited[row][col] = false;
        return count;
    }
}
