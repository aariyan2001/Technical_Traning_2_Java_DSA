public class GFG_MultiplyTwoMatrixes {
    

    public static void  Mutliply(int[][] matrixA, int[][] matrixB)
    {
        int[][] matrixC = new int[matrixA.length][matrixA.length];
        // code here
        for(int i=0;i<matrixA.length;i++){
            
            for(int k=0;k<matrixA.length;k++){
                int sum=0;
                
                for(int j=0;j<matrixA.length;j++){
                    int mul = matrixA[i][j]*matrixB[j][k];
                    sum = sum + mul; 
                    System.out.println(sum);
                }
                matrixC[i][k]=sum;
            }         
        }

        for(int i=0;i<matrixC.length;i++){            
            for(int k=0;k<matrixC.length;k++){
                matrixA[i][k] = matrixC[i][k];
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 1, 1}, {1, 1, 1},{1, 1, 1}};
        int[][] matrixB = {{1, 1, 1}, {1, 1, 1},{1, 1, 1}};

        Mutliply(matrixA,matrixB);
        for(int[] i : matrixA){
            System.out.println();
            for(int j : i){
                System.out.print(" "+j);
            }
        }
    }
    
}
