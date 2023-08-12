import java.util.ArrayList;
import java.util.List;


class SubArrayWithSumZero
{
    public static Boolean isSubArrayZero(int arr[])
    {
        //Using ArrayList for storing sum
        List<Integer> set = new ArrayList<>();
        int Sum = 0;

        //Traversing the whole array for subArray having sum equal zero
        for (int i = 0; i < arr.length; i++)
        {
            Sum += arr[i];
            if (arr[i] == 0 || Sum == 0 || set.contains(Sum))
                return true;

            set.add(Sum);
        }
        return false;
    }
    public static void main(String arg[]){

		int arr[] = {-3,2,3,1,6};
        System.out.println(isSubArrayZero(arr)==true?"Yes":"No");	
    }
}
    
