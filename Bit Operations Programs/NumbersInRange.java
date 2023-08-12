public class NumbersInRange {
    public static void main(String[] args) {
        int num=5,count=0;
        for(int i=0;i<=num;i++){
            if((num&i)==i){
                //System.out.print(i+" ");
                count++;
            }
        }
        System.out.println(count);
    }
}
