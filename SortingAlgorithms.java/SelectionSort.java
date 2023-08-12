public class SelectionSort {
    public static void selectionSort(int[] array, int size){
        for(int i=0;i<size-1;i++){
            int min = i;

            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
    public static void main(String[] args) {
        int array[] = {10,1,3,11,5,9,7,8};
        selectionSort(array, array.length);

        System.out.print("Sorted array is : ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
