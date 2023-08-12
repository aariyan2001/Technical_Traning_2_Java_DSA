public class ReverseANumber {
    public static void main(String[] args) {
        int num=145;
        String str="";
        while(num>0){
            str=str+(num%10);
            num=num/10;
        }
        System.out.println(Integer.parseInt(str));
    }
}
