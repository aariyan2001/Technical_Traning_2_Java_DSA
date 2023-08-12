import java.util.ArrayList;

public class Perfect {
    public static void isPerfect(int num,ArrayList<Integer> list,int value){
        int sum=0;
        if(value==num){
            return;
        }
        for(int i=1;i<value;i++){
            if(value%i==0){
                sum = sum+i;
            }
        }
       if(sum==value){
           list.add(sum);
       }
       isPerfect(num,list,value+1);
    }
       
    public static ArrayList<Integer> perfect(int n) {
           //To find the perfect number we can use formula 2^(p-1)*((2^p)-1) where p is prime number
           //or we can find proper divisors using recursion
           ArrayList<Integer> list = new ArrayList<>();
           isPerfect(n,list,2);
           return list;
       }
    public static void main(String[] args) {
        System.out.println(perfect(1000));
    }
}
