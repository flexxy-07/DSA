package Recursion;
import java.util.*;
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9]; // creates array of HashSets
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxxi = new HashSet[9];

        // Though Java has allocated space for them, but still they are initially null,
        // So we gotta initialize them;
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxxi[i] = new HashSet<>();
        }

        // Now iterating over the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;

                int boxxiInd = 3 * (row / 3) + (col / 3); // 0 - 8;

                if (rows[row].contains(ch) || cols[col].contains(ch) || boxxi[boxxiInd].contains(ch)){
                    return false;
                }else{
                    rows[row].add(ch);
                    cols[col].add(ch);
                    boxxi[boxxiInd].add(ch);
                }
            }
        }
        return true;
    }
}
