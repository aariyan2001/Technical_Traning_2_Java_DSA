import java.util.HashMap;

public class LeetCode_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int indexes[] = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hash.get(nums[i])==null){
                int index = target - nums[i];
                hash.put(index,i);
            }
            else{
                indexes[0] = hash.get(nums[i]);
                indexes[1] = i;
            }
        }
        return indexes;
    }
    public static void main(String[] args) {  
        int[] array = {1,2,5,8,6};      
        twoSum(array, 7);
    }
}
