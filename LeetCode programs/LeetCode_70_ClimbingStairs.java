public class LeetCode_70_ClimbingStairs {
    //A person can take 1 0r 2 steps only to climb up to stairs
    public static int climbstairs(int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        int count1 = climbstairs(n-1);
        int count2 = climbstairs(n-2);
        int count = count1+count2;
        return count;
    }

    //Another way is to find pattern (on careful observation the pattern looks like a fibonacci series)
    //Since on carefully examining the values are seem to be in fibonacci series we write the following code
    public static int climbStairs(int n) {
       
        //Since on carefully examining the values are seem to be in fibonacci series
        if(n==0||n==1||n==2||n==3){
            return n;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }     

    public static void main(String[] args) {
        System.out.println(climbstairs(5));
        System.out.println(climbStairs(5));
        
    }
}
