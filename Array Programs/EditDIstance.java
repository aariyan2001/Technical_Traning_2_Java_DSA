public class EditDIstance {
    public static int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // If s is empty, need j insertions to make it t
                } else if (j == 0) {
                    dp[i][j] = i; // If t is empty, need i deletions to make it t
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s = "geek", t = "gesek";
        System.out.println(editDistance(s, t));
    }
}
