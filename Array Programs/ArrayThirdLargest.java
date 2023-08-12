public class ArrayThirdLargest {
    public static void main(String[] args) {
        int array[] = {1,12,24,20,31,42};
        int fl=array[0],sl=0,tl=-1;

         if(array.length<2){
            System.out.println("Small array.....");
            return;
        }
        for(int i=1;i<array.length;i++){
            if(array[i]>fl){
                tl = sl;
                sl=fl;
                fl = array[i];
            }
            else if(array[i]>sl && array[i]!=fl){
                tl = sl;
                sl = array[i];
            }
            else if(array[i]>tl && array[i]!=fl && array[i]!=sl){
                tl = array[i];
            }
            
        }

        System.out.println("First Largest: "+fl);
        System.out.println("Second Largest: "+sl);
        System.out.println("Second Largest: "+tl);
    }
}
