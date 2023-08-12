public class Find_ith_bit {
    public static void main(String[] args) {
        int num=22;
        int i = 4;
        System.out.println((num>>i-1)&1);
    }
}
