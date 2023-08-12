import java.util.ArrayList;
import java.util.Arrays;

public class ArryCap {
    //using stack builder
    public static void toUppar(ArrayList<String> list,int index) {
        //Termination case
        if(index==list.size()){
            System.out.println(list);
            return;
        }
        //Business rule
        String str = list.get(index);
        list.remove(index);
        list.add(index, str.toUpperCase());
        //Recursive call
        toUppar(list, index+1);
    }

    //Using Stack Fall
    public static ArrayList<String> toUppar(String[] arr, int index) {
        //Termination case
        if(index==arr.length){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        
        //Recursive call
        ArrayList<String> result = toUppar(arr,index+1);
        result.add(0,arr[index].toUpperCase());
        return result;
    }
    

    public static void main(String[] args) {
        String[] arr = {"foo","bar","world"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList( arr));
        toUppar( list,0);
        System.out.println(toUppar(arr,0));

    }
}
