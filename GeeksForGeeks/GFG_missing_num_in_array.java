import java.util.Arrays;

public class GFG_missing_num_in_array {
     static int search(int[] arr,int num,int count){
        if(count>arr.length){
            return count;
        }
        if(count!=arr[count-1]){
            return count;
        }
        
        return search(arr,num,count+1);
    }
    
    static int missingNumber(int array[], int n) {
        Arrays.sort(array);
        return search(array,n,1);
    }

    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(missingNumber(array, 2));  //Output must be 2
    }
}
