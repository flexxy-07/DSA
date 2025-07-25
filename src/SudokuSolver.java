public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {};
        if (solve(board)){
            display(board);
        }else {
            System.out.println("Cannot solve the Sudoku");
        }

    }
    static boolean solve(int [][] board){
        int n = board.length;
        int row =-1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }

            }
            // if you found some empty element is row, then break
            if (emptyLeft == false){
                break;
            }

        }
        if (emptyLeft == true){
            return true;
            // sudoku is solved
        }
        
        // backtrack
        for (int number = 1; number <= 9 ; number++) {
            if (isSafe(board,row,col,number)){
                board[row][col] = number;
                if (solve(board)){
                    // found the answer

                    return true;
                }else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
            
        }
        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board){
            for (int number : row){
                System.out.print(number + " ");
            }
        }
    }

    static boolean isSafe(int [][] board, int row, int col, int num){
        // check the row
        for (int i = 0; i < board.length; i++) {
            // check if the number is in the row
            if (board[row][i]==num){
                return false;
            }
        }
        // check for the cols
        for (int[] nums : board){
            // check if the number is in the column
            if (nums[col] == num){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int rowstart = row - row% sqrt;
        int colstart = col - col%sqrt;
        for (int r = rowstart; r < rowstart + sqrt; r++) {
            for (int c = colstart; c < colstart+sqrt ; c++) {
                if (board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
