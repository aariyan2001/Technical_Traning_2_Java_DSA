public class ClimbingStarisDP {
    public static int climbStairs(int n) {
        /*
         //Since on carefully examining the values are seem to be in fibonacci series
         if(n==0||n==1||n==2||n==3){
             return n;
         }
         return climbStairs(n-1)+climbStairs(n-2);
         */
         /*
         if(n==0){
             return 1;
         }
         if(n<0){
             return 0;
         }
 
         int count1 = climbStairs(n-1);
         int count2 = climbStairs(n-2);
         int count = count1+count2;
         return count;
     }
     */
     if (n <= 2) {
             return n;
         }
         
         int[] dp = new int[n + 1];
         dp[1] = 1;
         dp[2] = 2;
         
         for (int i = 3; i <= n; i++) {
             dp[i] = dp[i - 1] + dp[i - 2];
         }
         
         return dp[n];
     }
     public static void main(String[] args) {
        System.out.println(climbStairs(6));
     }
}
