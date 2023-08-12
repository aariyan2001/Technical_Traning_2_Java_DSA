public class LeetCode_287_FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int max=0;
        for(int ele:nums){
            if(ele>max){
                max=ele;
            }
        }
        int[] array = new int[max+1];
        for(int ele:nums){
            if(array[ele]>0){
                return ele;
            }
            else{
                array[ele]++;
            }
        }
        return -1;
    }
     
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
