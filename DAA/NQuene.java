
import java.util.Arrays;
 
public class NQuene {
    public static void main(String[] args) {
       
         int count = 1;
         String[][] solutionsNew = solveNQueens3(4);
         for (String[] strings : solutionsNew) {
            System.out.println(Arrays.toString(strings));
         }

    }


     public static String[][] solveNQueens3(int n) {
        String[][] board2 = new String[n][n];
        Solution(0,board2);
        return board2;
    }
     
     
    public static boolean Solution(int row, String[][] board) {
      if(row>=board.length) 
        return true;

          for(int col=0 ;col <board.length; col++) {
            if (isSafe2(board, row, col)) {
                board[row][col]="Q";

                if ( Solution(row+1, board))
                    return true;

                 board[row][col]="_";
            }
          }

         return false;
    }

    private static boolean isSafe2(String[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == "Q")
                return false;
        } 

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q")
                return false;
        }

        for (int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == "Q")
                return false;
        }

        return true;
    }
}
