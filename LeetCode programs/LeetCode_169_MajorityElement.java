public class LeetCode_169_MajorityElement {
     public static int majorityElement(int[] nums) {
        int count = 0, maxElement = 0;
				for(int num: nums) {
					if(count == 0) {
						maxElement = num;
					}
					if(num == maxElement) {
						count++;
					} else {
						count--;
					}
				}

				return maxElement;
    }
    public static void main(String[] args) {
        int[] array = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(array));
    }
}
