public class LeetCode_75_SortColours {
    public static void sortColors(int[] nums) {
        /*
        Arrays.sort(nums); //It uses quicksort algo
        */
        int C0=0,C1=0,C2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                C0++;
            }
            if(nums[i]==1){
                C1++;
            }
            if(nums[i]==2){
                C2++;
            }
        }

        for(int i=0;i<C0;i++){
            nums[i]=0;
        }
        for(int i=0;i<C1;i++){
            nums[i+C0]=1;
        }
        for(int i=0;i<C2;i++){
            nums[i+C0+C1]=2;
        }
        
    }
    public static void main(String[] args) {
        int array[] = {1,0,1,2,0,2,0,2,1};
        sortColors(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}
