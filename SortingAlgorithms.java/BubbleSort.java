public class BubbleSort {
    public static void bubbleSort(int[] array,int size){
        boolean flag; //To break the loop if sorted
        int count=0; //to count the number of iterations it performed

        for(int i=0;i<size;i++){
            count++;
            flag=false;
            for(int j=1;j<size-i;j++){
                if(array[j-1]>array[j]){
                    int sw = array[j];
                    array[j] = array[j-1];
                    array[j-1] = sw;
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }
        }
        System.out.println("Iterations: "+count);
    }
    public static void main(String[] args) {
        int array[] = {10,1,3,11,5,9,7,8};
        //Performing bubble sort
        //Average Case and Wrost case time complexity is O(N^2)

        bubbleSort(array, array.length);
        System.out.print("Sorted array is : ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
