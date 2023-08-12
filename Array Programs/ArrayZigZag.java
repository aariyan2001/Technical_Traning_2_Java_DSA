public class ArrayZigZag {
    
    static void generateZigZag(int[] array){
        for(int i=0;i<array.length-2;i=i+2){
            if(!(array[i]<array[i+1])){
                int tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
            }
            if(!(array[i+1]>array[i+2])){
                int tmp = array[i+1];
                array[i+1] = array[i+2];
                array[i+1] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int array [] ={4,3,7,8,6,2,1};
        generateZigZag(array);
        for(int i:array){
            System.out.print(i+" ");
        }
        
    }
}
