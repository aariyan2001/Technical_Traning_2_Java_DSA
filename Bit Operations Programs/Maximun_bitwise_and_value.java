public class Maximun_bitwise_and_value {
    public static void main(String[] args) {
        int array[] = {3, 5, 8, 10, 12};
        int max=0;

        for(int i=1;i<array.length;i++){
            if((array[i-1]&array[i])>max){
                max = array[i-1]&array[i];
            }
        }
        System.out.println(max);
    }
}
