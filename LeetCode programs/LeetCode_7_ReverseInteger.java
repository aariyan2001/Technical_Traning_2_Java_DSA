class LeetCode_7_ReverseInteger {
    public static int reverse(int x) {
        long sum=0;
        int num=x;
        int flag=0;
        if(num<0){
            num = -x;
            flag=1;
        }else{
            num=x;
        }

        while(num>0){
            sum = sum*10+num%10;
            num=num/10;
        }
        if(sum<Math.pow(-2,31) || sum>Math.pow(2,31)){
            return 0;
        }
        else {
            if(flag==1){
                return (int) -sum;
            }
            else{
                return (int) sum;
            }
            
        }
    }
    public static void main(String[] args) {
        int num=-1234;
        System.out.println(reverse(num));
    }
}