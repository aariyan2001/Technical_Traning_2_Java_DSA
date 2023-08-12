import java.util.ArrayList;

public class productofnumbersfromlist {
    public static void product(ArrayList<Integer> result,int[] array,int index) {
        //Termination case
        if(index==array.length){
            System.out.println(result);
            return;
        }
        //Business logic
        result.add((int)Math.pow(array[index], 2));
        //Recursive call
        product(result, array, index+1);
    }

    public static ArrayList<Integer> product(int[] array,int index) {
        //Termination case
        if(index>=array.length){
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        //Recursive call
        ArrayList<Integer> result = product(array, index+1);
        //Business logic
        result.add(0,(int)Math.pow(array[index], 2));
        return result;
        
    }
    public static void main(String[] args) {
       int[] array = {1,2,3,4,5}; 
        //ArrayList<Integer> result = new ArrayList<>();
        //product(result,array, 0);
        //System.out.println(result);
        System.out.println(product(array,0));
        
    }
}
