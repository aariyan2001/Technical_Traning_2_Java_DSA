import java.util.ArrayList;
import java.util.Collections;

public class GFG_LeadersProblem {
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int max=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                max=arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        int array[] = {16, 17, 4, 3, 5, 2};
        int n=6;
        System.out.println(leaders(array, n));
    }
}
