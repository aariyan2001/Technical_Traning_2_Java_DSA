
public class GFG_setBits {
    static int setBits(int N) {
        // code here
        int count=0;
        while(N>0){
            if((N&1)==1){
                count++;
            }
            N = N>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(setBits(6));
    }
}
