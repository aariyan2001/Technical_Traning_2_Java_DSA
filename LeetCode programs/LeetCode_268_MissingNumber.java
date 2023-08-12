public class LeetCode_268_MissingNumber {
    public static int missingNumber(int[] nums) {
        // Your Code Here
        int n=nums.length;
       int sumOfN,sum=0;
       sumOfN = n*(n+1)/2;
       
       for(int ele:nums){
           sum = sum+ele;
       }
       return sumOfN-sum;
   }
   public static void main(String[] args) {
    int nums[] = {3,0,1};
    System.out.println(missingNumber(nums));
   }
}
