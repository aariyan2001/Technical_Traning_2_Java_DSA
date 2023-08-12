public class Set_bit_in_ith_position {
    public static void main(String[] args) {
        int num = 22;
        int i = 4;
        //set means place 1
        System.out.println(num|(1<<i-1));
    }
}
