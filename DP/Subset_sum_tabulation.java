package WebResume;

public class Subset_sum_tabulation {
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        return dp[n][sum];
    }
}
