import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_Nqueen {
    //static int N=4;
    static boolean[][] board ;
    static List<List<String>> result ;
    public static boolean isQueensafe( int row, int column) {
        //check 1 - Checking on above row
        for(int i = row;i>=0;i--){
            if(board[i][column]){
                //There is a queen
                return false;
            }
        }

        //Check 2 - Checking right diagonal
        //Checking left diagonal
       for(int i=row,j=column; i>=0 && j>=0; i--,j--){
        if(board[i][j]){
            //There is queen
            return false;
        }
       }

       //Checking right diagonal
       for(int i=row,j=column; i>=0 && j<board[row].length; i--,j++){
        if(board[i][j]){
            //There is queen
            return false;
        }
       }
       
        return true;
    }

    public static int nqueen(int currentrow) {
        int count=0;
        //Termination case
        if(currentrow==board.length){
            result.add(fillsolutionresult());
            return 1;
        }

        //From row we need to traverse column
        for(int column=0; column<board[currentrow].length; column++){
            
            //we have to place queen on queen but before placing check queen is safe or not
            if(isQueensafe(currentrow, column)){
                //placing the queen on board
                board[currentrow][column] = true;
                int result = nqueen(currentrow+1);
                count = count+result;
                //removing the queen due to not getting further possibilities
                //undo the placement
                board[currentrow][column] = false;
            }
        }
        return count;
    }

    static List<String> fillsolutionresult(){
        List<String> list = new ArrayList<>();
        String dots="";
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]){
                    dots+="Q";
                }
                else{
                    dots+=".";
                }
            }
            list.add(dots);
            dots="";
        }
        return list;
    }

    public static List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        board = new boolean[n][n];
        nqueen(0);
        return result;

    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
