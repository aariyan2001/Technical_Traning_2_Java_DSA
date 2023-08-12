public class isSubsetSumDP {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N + 1][sum + 1];

        // Initialize the first column with true, as subset with sum 0 is always possible
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }
    public static void main(String[] args) {
        int N = 6;
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 30;
        System.out.println(isSubsetSum(N, arr, sum));
    }
}
