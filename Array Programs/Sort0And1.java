public class Sort0And1 {
    public static void main(String[] args) {
        int arr[] = {0,1,0,0,1,1,1,0,0,1};
        //Count the Zeros
        int count = 0;
        for(int ele: arr){
            if(ele==0){
                count++;
            }
        }
        //fill zeros
        for(int i=0;i<count;i++){
            arr[i] = 0;
        }
        //fill rem. with 1
        for(int i=count;i<arr.length;i++){
            arr[i] = 1;
        }

        for(int i:arr){
            System.out.print(" "+i);
        }
    }
}
