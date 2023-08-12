public class LeetCode_372 {

    private static int num=0;

    public static int superPow(int a, int[] b) {
        int [] arr = new int[b.length-1];

        if(b.length==1 && num==0){
            return (int)Math.pow(a,b[0]);
        }
        else if(b.length==1){
            return ((int)Math.pow(a,num))%1337;
        }        

        num = num + b[0]*(int)Math.pow(10,b.length-1);
        System.arraycopy(b, 1, arr, 0, b.length-1);

        return superPow(a,arr);
    }
    public static void main(String[] args) {
        int[] arr = {1,0};
        System.out.println(superPow(2,arr));
    }
}
