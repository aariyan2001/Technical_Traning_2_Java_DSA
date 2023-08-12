
public class GFG_missingNumberInArray {
    static int missingNumber(int array[], int n) {
        // Your Code Here
        int sumOfN,sum=0;
        sumOfN = n*(n+1)/2;
        
        for(int ele:array){
            sum = sum+ele;
        }
        return sumOfN-sum;
    }
    public static void main(String[] args) {
        int array[] = {1,2,5,4};
        System.out.println(missingNumber(array, 5));
    }
}
