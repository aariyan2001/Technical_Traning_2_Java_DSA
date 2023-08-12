public class ClearLast_ith_Bit {
    public static void main(String[] args) {
        int num=22; //number
        int k=3; //Upto how many bit we have to clear
        int mask = ~0<<k;  //it will produce value "1111111000"
        System.out.println(num&mask);
    }
}
