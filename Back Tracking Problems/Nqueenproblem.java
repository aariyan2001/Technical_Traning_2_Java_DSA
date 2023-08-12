public class Nqueenproblem {
    public static boolean isQueensafe(boolean[][] Board, int row, int column) {
        //check 1 - Checking on above row
        for(int i = row;i>=0;i--){
            if(Board[i][column]){
                //There is a queen
                return false;
            }
        }

        //Check 2 - Checking right diagonal
        //Checking left diagonal
       for(int i=row,j=column; i>=0 && j>=0; i--,j--){
        if(Board[i][j]){
            //There is queen
            return false;
        }
       }

       //Checking right diagonal
       for(int i=row,j=column; i>=0 && j<Board[row].length; i--,j++){
        if(Board[i][j]){
            //There is queen
            return false;
        }
       }
       
        return true;
    }

    public static int nqueen(boolean[][] board, int currentrow) {
        int count=0;
        //Termination case
        if(currentrow==board.length){
            return 1;
        }

        //From row we need to traverse column
        for(int column=0; column<board[currentrow].length; column++){
            
            //we have to place queen on queen but before placing check queen is safe or not
            if(isQueensafe(board, currentrow, column)){
                //placing the queen on board
                board[currentrow][column] = true;
                int result = nqueen(board, currentrow+1);
                count = count+result;
                //removing the queen due to not getting further possibilities
                //undo the placement
                board[currentrow][column] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N=4;
        boolean [][] Board = new boolean[N][N];
        System.out.println(nqueen(Board,0));
    }
}
