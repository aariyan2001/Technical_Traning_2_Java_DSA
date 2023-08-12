package WebResume;

public class Subset_sum_recursion {
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        // Base case
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        
        if (arr[n - 1] > sum) {
            return isSubsetSum(n - 1,arr, sum);
        }
        
        return isSubsetSum(n - 1, arr, sum - arr[n - 1]) || isSubsetSum(n - 1, arr, sum);
    }
}
