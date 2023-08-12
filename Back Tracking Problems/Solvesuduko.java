public class Solvesuduko {
    char[][] board;
    int max = 9;

    private boolean isPresentinrow(int row, int column, char value){
        //The value is present in row
        for(int col=0 ; col<max;col++){
            if(board[row][col]==value){
                return true;
            }
        }
        return false;
    }

    private boolean isPresentincol(int row, int column, char value){
        //The value is present in column
        for(int r =0; r <max;r++){
            if(board[r][column]==value){
                return true;
            }
        }
        return false;
    }

    private boolean isPresentingrid(int row, int column, char value){
        //The value is present in grid
        int startrow = row - row%3;
        int startcolumn = column - column%3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcolumn;j<startcolumn+3;j++){
                if(board[i][j]==value){
                    return true;
                }
            }
        } 
        return false;
    }

    private boolean isCorrectToPlace(int row, int column, char value){

        return !isPresentinrow(row,column,value) && !isPresentincol(row,column,value) && !isPresentingrid(row,column,value); 

        
    }
    
    private boolean solvesuduko( int row, int col ){
         //if we reach the last row+1 then we solved the suduko
         if(row==max){ //Termination
             return true;
         }

        //If we reach to last column, then move to the next row
        if(col==max){
            //Jump to the next row
            row=row+1;
            col=0; 
        }        
        //if cell is not empty so move to the next column
        if(board[row][col]!='.'){
            return solvesuduko(row,col+1);
        }        
         //If cell is empty, then place the digit  (from 1 to 9 (Loop)) with pre check
        for(int i=1;i<=max;i++){
            //IsCorrectToPlace
            if( isCorrectToPlace( row, col, (char)(i+'0')) ){
                board[row][col] = (char)(i+'0'); 
                //Move to the next column
                boolean result = solvesuduko(row,col+1);
                if(result){
                    //Solved the suduko
                    return true;
                }
                //now do back tracking
                board[row][col]='.'; //empty the cells
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        solvesuduko(0,0);
    }

   
} 
