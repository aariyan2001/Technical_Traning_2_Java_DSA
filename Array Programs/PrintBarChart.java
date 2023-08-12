public class PrintBarChart {
    public static void main(String[] args) {
        int array[]={2,1,7,9,0};
        int max=0;
        for(int ele:array){
            if(max<ele){
                max=ele;
            }
        }
        while(max>0){
            for(int i=0;i<array.length;i++){
               if(array[i]>=max){
                System.out.print(" *");
               }else{
                System.out.print("  ");
               }
            }
            System.out.println();
            max--;
        }
        
    }
}
