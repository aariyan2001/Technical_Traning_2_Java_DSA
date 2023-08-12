public class LeetCode_1922_CountGoodNumbers {
    public static int countGoodNumbers(long n) {
        int mod = (int)Math.pow(10,9)+7;
        long even = 0;
        long prime = 0;  

        if(n%2==0){
            even = n/2;
            prime = n/2;            
        }else{
            even = (n+1)/2;
            prime = n-even;
        }

        long even_places = pow(5,even);
        long odd_places = pow(4, prime);
        long ans = (even_places * odd_places) % mod;
        return (int)ans;

    }

    public static long pow(int x, long n){
        int mod = (int)Math.pow(10,9)+7;
        
        if(n==0){
            return 1;
        }

        long ans = pow(x,n/2);
        ans = ans * ans%mod;

        if(n%2==0){
            return ans;
        }
        return x * ans%mod;
    }
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(4));
    }
}
