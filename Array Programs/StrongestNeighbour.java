public class StrongestNeighbour {
    public static void main(String[] args) {
        int array[] = {1,3,6,8,3,5};
        int result[] = new int[array.length-1];
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                result[i]=array[i];
            }
            else{
                result[i]=array[i+1];
            }
        }
        for(int ele:result){
            System.out.print(ele+" ");
        }
     }
}
