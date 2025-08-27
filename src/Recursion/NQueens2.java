package Recursion;
import java.util.*;
public class NQueens2 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(totalNQueens(n));
    }
    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return solve(board,0);
    }
    private static int solve(char[][] board,int col){
        if (col == board.length){
            return 1;
        }
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board,row,col)){
                board[row][col] = 'Q';
                count += solve(board,col + 1);
                board[row][col] = '.';
            }
        }
        return count;
    }
    private static boolean isSafe(char[][] board,int row, int col){
        int orgRow = row;
        int orgCol = col;

        // upper-left check
        while(row >= 0 && col >= 0){
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = orgRow;
        col = orgCol;

        // left check
        while (col >= 0){
            if (board[row][col] == 'Q') return false;
            col--;
        }
        col = orgCol;

        while (row < board.length && col >= 0){
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}
