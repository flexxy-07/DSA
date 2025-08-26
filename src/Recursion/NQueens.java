package Recursion;

import java.util.*;
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));

    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
         char[][] board = new char[n][n];
         for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
         }
         solve(board,ans,0);
         return ans;
    }
    private static void solve(char[][] board,List<List<String>> ans,int col){
        if (col == board.length){
            List<String> list = new ArrayList<>();
            for (char[] r : board){
                list.add(new String(r));
            }
            ans.add(list);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                solve(board,ans,col + 1);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isSafe(char[][] board,int row, int col){
        int orgRow = row;
        int orgCol = col;

        // upper-left check
        while (row >= 0 && col >= 0){
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = orgRow;
        col = orgCol;
        // left-check
        while (col >= 0){
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = orgRow;
        col = orgCol;
        // lower left check
        while (row < board.length  && col >= 0){
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}
