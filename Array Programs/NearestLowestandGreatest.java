public class NearestLowestandGreatest {
    public static void main(String[] args) {
        int array[] = {10,20,30,40,50,60,70,80,90,100};
        int low=0;
        int high = array.length-1;
        int searchElement = 72;
        int i=0;
        int nearestLowest = 0;
        int nearestGreater = 0;
        while(i<array.length){
            int mid = (low+high)/2;
            if(searchElement>array[mid]){
                nearestLowest=array[mid];
                low=mid+1;
            }
            else if(searchElement<array[mid]){
                nearestGreater = array[mid];
                high = mid-1;
            }
            else if(array[mid]==searchElement){
                nearestLowest = nearestGreater = array[mid];
                return;
            }
            i++;
        }
        System.out.println("Nearest Greater : "+ nearestGreater+ " Nearest Lowest : "+ nearestLowest);
    }
}
