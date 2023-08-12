public class LeetCode_26_RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
    }
    public static void main(String[] args) {
        int array[] = {1,1,2};
        System.out.println(removeDuplicates(array));
    }
}
