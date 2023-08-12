public class ArraySecondLargest {
    public static void main(String[] args) {
        int array[] = {1,12,24,20,31,42};
        int max=array[0],sL=0;

        /*
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]>sL && array[i]!=max){
                sL=array[i];
            }
        }
        */
        if(array.length<2){
            System.out.println("Small array.....");
            return;
        }
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                sL = max;
                max = array[i];
            }
            else if(array[i]>sL && array[i]!=max){
                sL = array[i];
            }
            
        }

        System.out.println("First Largest: "+max);
        System.out.println("Second Largest: "+sL);
    }
}
