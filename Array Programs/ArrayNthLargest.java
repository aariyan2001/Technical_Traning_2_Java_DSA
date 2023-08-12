import java.util.Arrays;

public class ArrayNthLargest {
    public static void main(String[] args) {
        int array[] = {1,12,24,20,31,42};
        
        int N=3;

         if(array.length<2){
            System.out.println("Small array.....");
            return;
        }
        if(N<array.length){
            Arrays.sort(array);
            System.out.println("Nth Largest: "+array[(array.length-N)]);
        }          
    }
    
}
