public class ReverseAnArray {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6};
        int low=0;
        int high=array.length-1;

        while(low<high){
            int tmp=array[low];
            array[low] = array[high];
            array[high] = tmp;
            low++;
            high--;
        }
        for(int ele:array){
            System.out.print(ele+" ");
        }
    }
}
