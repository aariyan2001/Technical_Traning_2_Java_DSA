

public class GFG_AdditionOfTwoSquareMatrix {
    public static void  Addition(int[][] matrixA, int[][] matrixB)
    {
        // code here
        for(int i=0;i<matrixA.length;i++){
            for(int j=0;j<matrixB.length;j++){
                matrixA[i][j] = matrixA[i][j]+matrixB[i][j]; 
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{4, 3}, {2, 1}};
        Addition(matrixA,matrixB);
        for(int[] i : matrixA){
            System.out.println();
            for(int j : i){
                System.out.print(" "+j);
            }
        }
    }
}
