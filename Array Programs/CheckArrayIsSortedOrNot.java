public class CheckArrayIsSortedOrNot {
    public static void main(String[] args) {
        int array[]={1,2,3,0};
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                System.out.println("Not Soretd.....");
                return;
            }
        }
        System.out.println("Array is Sorted.....");
    }
}
