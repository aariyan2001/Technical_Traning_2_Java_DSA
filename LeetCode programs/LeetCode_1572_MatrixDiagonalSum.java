public class LeetCode_1572_MatrixDiagonalSum {
    public static int rightDiagonal(int[][] mat){
        int sum=0;
        for(int i=0;i<mat.length;i++){
            sum = sum + mat[i][i];
        }
        return sum;
    }

    public static int leftDiagonal(int[][] mat){
        int sum=0;
        for(int i=0;i<mat.length;i++){
            sum = sum + mat[i][(mat.length-1)-i];
        }
        return sum;
    }

    public static int diagonalSum(int[][] mat) {
        if(mat.length%2==0){
            return (rightDiagonal(mat)+leftDiagonal(mat));
        }
        else{
            return (rightDiagonal(mat)+leftDiagonal(mat))-mat[mat.length/2][mat.length/2];
        }
        
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }
}
