public interface LeetCode_136_SingleNumber {
     public static int singleNumber(int[] nums) {
        //Using Bit Manipulation
        //since in XOR the same number after XOR becomes zero
        //Hence only single number will remain

        int val=0;
        for(int i:nums){
            val = val^i;
        }
        return val;
    }

    public static void main(String[] args) {
        int array[] = {4,1,2,1,2};
        System.out.println(singleNumber(array));
    }
}
